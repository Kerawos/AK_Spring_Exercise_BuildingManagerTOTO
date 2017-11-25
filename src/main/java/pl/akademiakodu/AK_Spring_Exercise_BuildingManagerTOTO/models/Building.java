package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models;

import java.math.BigInteger;

public class Building {

    private int width;
    private int length;
    private int floors;
    private int undergroundFloors;

    private int totalBuildingArea;
    private int officeLevel;
    private int parkingLevel;
    private int serviceLevel;
    private int gastroLevel;

    private int elevator;
    private int rooms;
    private int straits;
    private int toilets;

    private int potentialWorkers;
    private BigInteger potentialBuildingCost;
    private int potentialMonthlyCharges;

    public Building() {
    }

    public Building(int width, int length, int floors, int undergroundFloors, int totalBuildingArea, int officeLevel,
                    int parkingLevel, int serviceLevel, int gastroLevel, int elevator, int rooms, int straits,
                    int toilets, int potentialWorkers, BigInteger potentialBuildingCost, int potentialMonthlyCharges) {
        this.width = width;
        this.length = length;
        this.floors = floors;
        this.undergroundFloors = undergroundFloors;
        this.totalBuildingArea = totalBuildingArea;
        this.officeLevel = officeLevel;
        this.parkingLevel = parkingLevel;
        this.serviceLevel = serviceLevel;
        this.gastroLevel = gastroLevel;
        this.elevator = elevator;
        this.rooms = rooms;
        this.straits = straits;
        this.toilets = toilets;
        this.potentialWorkers = potentialWorkers;
        this.potentialBuildingCost = potentialBuildingCost;
        this.potentialMonthlyCharges = potentialMonthlyCharges;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getUndergroundFloors() {
        return undergroundFloors;
    }

    public void setUndergroundFloors(int undergroundFloors) {
        this.undergroundFloors = undergroundFloors;
    }

    public int getTotalBuildingArea() {
        return totalBuildingArea;
    }

    public void setTotalBuildingArea(int totalBuildingArea) {
        this.totalBuildingArea = totalBuildingArea;
    }

    public int getOfficeLevel() {
        return officeLevel;
    }

    public void setOfficeLevel(int officeLevel) {
        this.officeLevel = officeLevel;
    }

    public int getParkingLevel() {
        return parkingLevel;
    }

    public void setParkingLevel(int parkingLevel) {
        this.parkingLevel = parkingLevel;
    }

    public int getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(int serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public int getGastroLevel() {
        return gastroLevel;
    }

    public void setGastroLevel(int gastroLevel) {
        this.gastroLevel = gastroLevel;
    }

    public int getElevator() {
        return elevator;
    }

    public void setElevator(int elevator) {
        this.elevator = elevator;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getStraits() {
        return straits;
    }

    public void setStraits(int straits) {
        this.straits = straits;
    }

    public int getToilets() {
        return toilets;
    }

    public void setToilets(int toilets) {
        this.toilets = toilets;
    }

    public int getPotentialWorkers() {
        return potentialWorkers;
    }

    public void setPotentialWorkers(int potentialWorkers) {
        this.potentialWorkers = potentialWorkers;
    }

    public BigInteger getPotentialBuildingCost() {
        return potentialBuildingCost;
    }

    public void setPotentialBuildingCost(BigInteger potentialBuildingCost) {
        this.potentialBuildingCost = potentialBuildingCost;
    }

    public int getPotentialMonthlyCharges() {
        return potentialMonthlyCharges;
    }

    public void setPotentialMonthlyCharges(int potentialMonthlyCharges) {
        this.potentialMonthlyCharges = potentialMonthlyCharges;
    }

    @Override
    public String toString() {
        return "Building{" +
                "width=" + width +
                ", length=" + length +
                ", floors=" + floors +
                ", undergroundFloors=" + undergroundFloors +
                ", totalBuildingArea=" + totalBuildingArea +
                ", officeLevel=" + officeLevel +
                ", parkingLevel=" + parkingLevel +
                ", serviceLevel=" + serviceLevel +
                ", gastroLevel=" + gastroLevel +
                ", elevator=" + elevator +
                ", rooms=" + rooms +
                ", straits=" + straits +
                ", toilets=" + toilets +
                ", potentialWorkers=" + potentialWorkers +
                ", potentialBuildingCost=" + potentialBuildingCost +
                ", potentialMonthlyCharges=" + potentialMonthlyCharges +
                '}';
    }
}
