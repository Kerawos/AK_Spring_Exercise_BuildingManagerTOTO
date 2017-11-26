package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CostBuilding {

    private double areaMinimumIndicator = 1.2;
    private double undergroundLevelIndicator = 1.3;
    private int costMaterialFloorPerAreaMeter = 40;
    private int costMaterialRoofPerAreaMeter = 90;
    private int costMaterialWallPerMeter = 52;
    private int costInstallationPerAreaMeter = 19;
    private int costElectronicsPerAreaMeter = 130;
    private double costFoundationPerFloor = 1.2;
    private int costGroundPerMeter = 1500;
    private int costLicenceBuilding = 35000;
    private int costEnvironmentPerLevel = 2400;

    private int limitOfFloors = 25;
    private int limitOfUndergroundFloors = 7;
    private int limitOfArea = 35000;


    public BigInteger calcTotalCostOfBuilding(int width, int length, int floors, int undergroundFloors){
        BigInteger totalCost = new BigInteger("0");
        int areaLevel = width * length;
        totalCost = totalCost.add(BigInteger.valueOf(getCostLicenceBuilding()));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfGround(calcBuildingArea(areaLevel))));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfEnvironmentLevel(floors + undergroundFloors)));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfRoof(areaLevel)));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfFoundation(areaLevel, floors)));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfElectronic(areaLevel) * floors));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostOfInstallation(areaLevel) * floors));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostMaterialFloor(areaLevel) * floors));
        totalCost = totalCost.add(BigInteger.valueOf(calcCostMaterialAreaWalls(width, length, floors)));
        totalCost = totalCost.add(BigInteger.valueOf(calcTotalCostUndergroundLevel(width, length, undergroundFloors)));
        return totalCost;
    }

    public int calcCostOfFoundation(int areaLevel, int floors){
        //todo implement function
        return 0;

    }

    public int calcBuildingArea(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return (int)(areaLevel * getAreaMinimumIndicator());
    }

    public int calcCostOfGround(int buildingArea){
        if (buildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return buildingArea * getCostGroundPerMeter();
    }

    public int calcCostOfEnvironmentLevel(int floors){
        if (floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkFloors(floors)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return getCostEnvironmentPerLevel() * floors;
    }

    public int calcCostOfRoof(int areaLevel){
        //todo implements
        return 0;
    }

    public int calcCostOfElectronic(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostElectronicsPerAreaMeter();
    }

    public int calcCostOfInstallation(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostInstallationPerAreaMeter();
    }

    public int calcCostMaterialFloor(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostMaterialFloorPerAreaMeter();
    }

    public int calcCostMaterialAreaWalls(int width, int length, int floors){
        if (width<1 || length<1 || floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(width * length) || !checkFloors(floors)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        if (floors==0){
            return ((width + length) * 2 ) * getCostMaterialWallPerMeter();
        }
        return (((width*2) + (length*2)) * floors) * getCostMaterialWallPerMeter();
    }

    public int calcTotalCostUndergroundLevel(int width, int length, int undergroundFloors){
        int areaLevel = width * length;
        if (undergroundFloors<0 || areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel) || !checkUndergroundFloors(undergroundFloors)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        if (undergroundFloors==0){
            return 0;
        }
        double potentialUndergroundCost = calcCostMaterialAreaWalls(width, length, 0) + calcCostMaterialFloor(areaLevel);
        double fouCos = getUndergroundLevelIndicator();

        //todo repair loop below
        for (int i = 1; i <= undergroundFloors; i++) {
            fouCos*=getCostFoundationPerFloor();
            potentialUndergroundCost*=potentialUndergroundCost;
        }
        return (int)(potentialUndergroundCost * fouCos);
    }

    public boolean checkArea(int areaLevel){
        return areaLevel > getLimitOfArea() ? false : true;
    }

    public boolean checkFloors(int floor){
        return floor > getLimitOfFloors() ? false : true;
    }

    public boolean checkUndergroundFloors(int undergroundFloor){
        return undergroundFloor > getLimitOfUndergroundFloors() ? false : true;
    }


    //getters
    public double getAreaMinimumIndicator() {
        return areaMinimumIndicator;
    }

    public double getUndergroundLevelIndicator() {
        return undergroundLevelIndicator;
    }

    public int getCostMaterialFloorPerAreaMeter() {
        return costMaterialFloorPerAreaMeter;
    }

    public int getCostMaterialRoofPerAreaMeter() {
        return costMaterialRoofPerAreaMeter;
    }

    public int getCostMaterialWallPerMeter() {
        return costMaterialWallPerMeter;
    }

    public int getCostInstallationPerAreaMeter() {
        return costInstallationPerAreaMeter;
    }

    public int getCostElectronicsPerAreaMeter() {
        return costElectronicsPerAreaMeter;
    }

    public double getCostFoundationPerFloor() {
        return costFoundationPerFloor;
    }

    public int getCostGroundPerMeter() {
        return costGroundPerMeter;
    }

    public int getCostLicenceBuilding() {
        return costLicenceBuilding;
    }

    public int getCostEnvironmentPerLevel() {
        return costEnvironmentPerLevel;
    }

    public int getLimitOfFloors() {
        return limitOfFloors;
    }

    public int getLimitOfUndergroundFloors() {
        return limitOfUndergroundFloors;
    }

    public int getLimitOfArea() {
        return limitOfArea;
    }
}
