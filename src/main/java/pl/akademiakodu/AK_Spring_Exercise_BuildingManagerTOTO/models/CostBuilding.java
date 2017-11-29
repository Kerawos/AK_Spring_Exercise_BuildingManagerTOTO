package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models;

import org.springframework.stereotype.Service;
import java.math.BigInteger;

/**
 * to calculate build cost of building.
 */
@Service
public class CostBuilding {

    /**
     * mainly material cost variable holders, example of real costs specified in specific period of time.
     */
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

    /**
     *
     * @param width given one of key variable to calculate cost of potential building
     * @param length given one of key variable to calculate cost of potential building
     * @param floors given one of key variable to calculate cost of potential building
     * @param undergroundFloors given one of key variable to calculate cost of potential building
     * @return total cost of potential building, including materials, scalable levels
     */
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

    /**
     * larger and taller building need bigger and more solid foundation, in that case cost is scalable per building size
     * @param areaLevel given level area of building
     * @param floors given levels of building
     * @return scalable cost of foundation
     */
    public int calcCostOfFoundation(int areaLevel, int floors){
        //todo implement function
        return 0;

    }

    /**
     * @param areaLevel given area of building level
     * @return minimum area for building
     */
    public int calcBuildingArea(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return (int)(areaLevel * getAreaMinimumIndicator());
    }

    /**
     * @param buildingArea given area of building level
     * @return cost of minimum area needed to build building
     */
    public int calcCostOfGround(int buildingArea){
        if (buildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return buildingArea * getCostGroundPerMeter();
    }

    /**
     * @param floors given total floors in the building
     * @return cost of environment tax depend of given building levels
     */
    public int calcCostOfEnvironmentLevel(int floors){
        if (floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkFloors(floors)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return getCostEnvironmentPerLevel() * floors;
    }

    /**
     * @param areaLevel given one level area of building
     * @return cost of last floor ceiling and roof
     */
    public int calcCostOfRoof(int areaLevel){
        //todo implements
        return 0;
    }

    /**
     * @param areaLevel given one level area of building
     * @return potential cost of office average quality electronics
     */
    public int calcCostOfElectronic(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostElectronicsPerAreaMeter();
    }

    /**
     * @param areaLevel given one level area of building
     * @return potential cost of cables, tubes, ventilation, sensors etc..
     */
    public int calcCostOfInstallation(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostInstallationPerAreaMeter();
    }

    /**
     * @param areaLevel given one level area of building
     * @return cost of potential one floor level
     */
    public int calcCostMaterialFloor(int areaLevel){
        if (areaLevel<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (!checkArea(areaLevel)){
            throw new IllegalArgumentException("Arguments over limits!");
        }
        return areaLevel * getCostMaterialFloorPerAreaMeter();
    }

    /**
     * @param width of building
     * @param length of building
     * @param floors of building
     * @return cost of potential walls of one building level
     */
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

    /**
     * underground levels are specified, cause of specific cost which raise fast per every deeper level.
     * @param width of building
     * @param length of building
     * @param undergroundFloors of building
     * @return scalable cost of potential undergorund building level
     */
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

    /**
     * @param areaLevel given one level area of building
     * @return information if potential area of building fits building space established standards
     */
    public boolean checkArea(int areaLevel){
        return areaLevel > getLimitOfArea() ? false : true;
    }

    /**
     * @param floor given building floors
     * @return information if potential building height fits building established standards
     */
    public boolean checkFloors(int floor){
        return floor > getLimitOfFloors() ? false : true;
    }

    /**
     * in some places investors cannot dig under specified level to protect nearby buildings and deposits of e.g: ore
     * @param undergroundFloor given underground floors
     * @return information if potential building underground levels fits building established standards
     */
    public boolean checkUndergroundFloors(int undergroundFloor){
        return undergroundFloor > getLimitOfUndergroundFloors() ? false : true;
    }

    /**
     * @getters variable holders
     */
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
