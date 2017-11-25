package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models;

public class BuildingManager {

    private int installationSpace = 4;
    private int toiletsSpace = 30;
    private int straitsSpace = 20;
    private int roomSpace = 40;
    private int elevatorSpace = 5;

    private double elevatorNeedPerLevel = 0.01;
    private double elevatorNeedPerArea10 = 0.02;
    private double straitsNeedPerArea50 = 0.07;
    private double emptyAreaNeedPerArea = 0.25;
    private double toiletNeedPerRoom = 0.3;
    private int workerAreaNeed = 4;
    private int parkingNeedPerOfficeLevel = 6;
    private int servicesNeedPerOfficeLevel = 5;
    private int gastroNeedPerLevel = 7;


    public int calculateLevelArea(int width, int length){
        if (width<1 || length<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return width * length;
    }

    public int roomCalculator(int levelArea, int elevators, int toilets, int straits){
        if (levelArea<1 || elevators<0 || toilets<1 || straits<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        int remainingSpace = levelArea;
        remainingSpace -= levelArea * getEmptyAreaNeedPerArea();
        remainingSpace -= elevators * getElevatorSpace();
        remainingSpace -= toilets * getToiletsSpace();
        remainingSpace -= straits * getStraitsSpace();
        return remainingSpace / getRoomSpace();
    }

    public int needsElevator(int levelArea, int floors){
        if (floors==0){
            return 0;
        }
        if (levelArea<1 || floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(((double)levelArea/10) * getElevatorNeedPerArea10() + ((double)floors*getElevatorNeedPerLevel()));
    }

    public int needsStraits(int levelArea, int floors){
        if (floors==0){
            return 0;
        }
        if (levelArea<1 || floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        int straits = (int)(((double)levelArea/50) * getStraitsNeedPerArea50() + ((double)floors * getElevatorNeedPerLevel()));
        return straits > 0 ? straits : 1;
    }

    public int needsParkingLevel(int floors){
        if (floors<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }

        return floors / getParkingNeedPerOfficeLevel();
    }

    public int needsServiceLevel(int officeLevel){
        //todo implements
        return 0;
    }

    public int needGastroLevel(int floors){
        if (floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return floors / getGastroNeedPerLevel();
    }

    public int needsToilets(int rooms){
        if (rooms<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(rooms * getToiletNeedPerRoom());
    }

    public int potentialWorkers(int rooms){
        if (rooms<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return rooms * getWorkerAreaNeed();
    }

    public int calcTotalBuildingArea(int width, int length, int floors){
        if (floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (floors==0){
            return calculateLevelArea(width, length);
        }
        return calculateLevelArea(width, length) * floors;
    }

    public Building totalCostCalculator(int width, int length, int floors, int undergroundFloors){
        int levelArea = calculateLevelArea(width, length);
        Building building = new Building();
        building.setWidth(width);
        building.setLength(length);
        building.setFloors(floors);
        building.setUndergroundFloors(undergroundFloors);

        building.setTotalBuildingArea(calcTotalBuildingArea(width, length, floors));
        building.setParkingLevel(needsParkingLevel(floors));
        building.setGastroLevel(needGastroLevel(floors));
        building.setServiceLevel(needsServiceLevel(floors));
        building.setOfficeLevel(floors - building.getParkingLevel() - building.getGastroLevel() - building.getServiceLevel());

        building.setElevator(needsElevator(levelArea, floors));
        building.setStraits(needsStraits(levelArea, floors));

        int potentialToiletsInBuilding = 0;
        int potentialRoomsInBuilding = 0;
        //todo implements correct way on set counted toilets and rooms, remember that they are very dependent each other.
        building.setToilets(potentialToiletsInBuilding);
        building.setRooms(potentialRoomsInBuilding);

        building.setPotentialWorkers(potentialWorkers(building.getRooms()));
        building.setPotentialBuildingCost(new CostBuilding().calcTotalCostOfBuilding(width, length, floors, undergroundFloors));
        building.setPotentialMonthlyCharges(new CostExploration().calcTotalChargesMonthly(building.getToilets(), building.getElevator(), building.getTotalBuildingArea(), building.getPotentialWorkers()));
        return building;
    }

    public int totalFlors(int floors, int undergroundFloors){
        return floors + undergroundFloors;
    }


    //getters
    public int getInstallationSpace() {
        return installationSpace;
    }

    public int getToiletsSpace() {
        return toiletsSpace;
    }

    public int getStraitsSpace() {
        return straitsSpace;
    }

    public int getRoomSpace() {
        return roomSpace;
    }

    public double getElevatorNeedPerLevel() {
        return elevatorNeedPerLevel;
    }

    public double getElevatorNeedPerArea10() {
        return elevatorNeedPerArea10;
    }

    public int getElevatorSpace() {
        return elevatorSpace;
    }

    public double getStraitsNeedPerArea50() {
        return straitsNeedPerArea50;
    }

    public double getEmptyAreaNeedPerArea() {
        return emptyAreaNeedPerArea;
    }

    public int getParkingNeedPerOfficeLevel() {
        return parkingNeedPerOfficeLevel;
    }

    public int getServicesNeedPerOfficeLevel() {
        return servicesNeedPerOfficeLevel;
    }

    public int getGastroNeedPerLevel() {
        return gastroNeedPerLevel;
    }

    public double getToiletNeedPerRoom() {
        return toiletNeedPerRoom;
    }

    public int getWorkerAreaNeed() {
        return workerAreaNeed;
    }
}
