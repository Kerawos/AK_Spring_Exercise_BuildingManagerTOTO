package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.services;

/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.Building;

/**
 * Service responsible for general calculations of potential building. Show results are listed below as well as cost
 * of building and later exploration. Helps comparison to existing costs of e.g: lease to potential own building.
 */
@Service
public class BuildingManager {

    /**
     * variable holder, example of real needs, taxes
     */
    private final int installationSpace = 4;
    private final int toiletsSpace = 30;
    private final int straitsSpace = 20;
    private final int roomSpace = 40;
    private final int elevatorSpace = 5;
    private final double elevatorNeedPerLevel = 0.01;
    private final double elevatorNeedPerArea10 = 0.02;
    private final double straitsNeedPerArea50 = 0.07;
    private final double emptyAreaNeedPerArea = 0.25;
    private final double toiletNeedPerRoom = 0.3;
    private final int workerAreaNeed = 4;
    private final int parkingNeedPerOfficeLevel = 6;
    private final int servicesNeedPerOfficeLevel = 5;
    private final int gastroNeedPerLevel = 7;

    /**
     * Method calculate area of one level in the building
     * @param width given of building
     * @param length given of building
     * @return area of one level on the building
     */
    public int calculateLevelArea(int width, int length){
        if (width<1 || length<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return width * length;
    }

    /**
     * Method calculate rooms in the building after gets area needs of other rooms
     * @param levelArea of the building
     * @param elevators in the building
     * @param toilets in the building
     * @param straits in the building
     * @return remaining space needed to one room, per all rooms
     */
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

    /**
     * Methods calculate how many elevators building should have
     * @param levelArea of the building
     * @param floors in the building
     * @return needed elevators
     */
    public int needsElevator(int levelArea, int floors){
        if (floors==0){
            return 0;
        }
        if (levelArea<1 || floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(((double)levelArea/10) * getElevatorNeedPerArea10() + ((double)floors*getElevatorNeedPerLevel()));
    }

    /**
     * Methods calculate how many straits building should have
     * @param levelArea of the building
     * @param floors in the building
     * @return needed straits
     */
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

    /**
     * Methods calculate how many parking levels building should have
     * @param floors in the building
     * @return needed parking levels
     */
    public int needsParkingLevel(int floors){
        if (floors<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }

        return floors / getParkingNeedPerOfficeLevel();
    }

    /**
     * Methods calculate how many service levels building should have
     * in this example office level are core of building as a office building, service levels are responsible of
     * security, cleanliness, deposits, cloakrooms etc..
     * @param officeLevel in the building
     * @return needed service levels
     */
    public int needsServiceLevel(int officeLevel){
        //todo implements
        return 0;
    }

    /**
     * Methods calculate how many gastro levels building should have
     * almost in every office gastro is needed.
     * @param floors in the building
     * @return potential needed gastros
     */
    public int needGastroLevel(int floors){
        if (floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return floors / getGastroNeedPerLevel();
    }

    /**
     * Methods calculate how many toilets building should have
     * @param rooms in the building
     * @return needed toilets
     */
    public int needsToilets(int rooms){
        if (rooms<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(rooms * getToiletNeedPerRoom());
    }

    /**
     * Methods calculate how many workers building can store
     * @param rooms in the building
     * @return potential worker maximum capacity accepted by given law
     */
    public int potentialWorkers(int rooms){
        if (rooms<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return rooms * getWorkerAreaNeed();
    }

    /**
     * Methods calculate total building area
     * @param width on the building
     * @param length on the building
     * @param floors in the building
     * @return total building area
     */
    public int calcTotalBuildingArea(int width, int length, int floors){
        if (floors<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        if (floors==0){
            return calculateLevelArea(width, length);
        }
        return calculateLevelArea(width, length) * floors;
    }

    /**
     * Calculate every cost connected on the potential building. Also inform of needed building maintains like: toilets,
     * rooms, straits and elevators, specified levels: office, service, parking and gastro. Output information of potential
     * workers capacity.
     * @param width of the building
     * @param length of the building
     * @param floors in the building
     * @param undergroundFloors in the building
     * @return all potential building information
     */
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
        building.setToilets(potentialToiletsInBuilding); //  needsToilets()
        building.setRooms(potentialRoomsInBuilding); // needsRooms()

        building.setPotentialWorkers(potentialWorkers(building.getRooms()));
        building.setPotentialBuildingCost(new CostBuilding().calcTotalCostOfBuilding(width, length, floors, undergroundFloors));
        building.setPotentialMonthlyCharges(new CostExploration().calcTotalChargesMonthly(building.getToilets(), building.getElevator(), building.getTotalBuildingArea(), building.getPotentialWorkers()));
        return building;
    }

    /**
     * @param floors in the building
     * @param undergroundFloors in the building
     * @return total floors in the building
     */
    public int totalFlors(int floors, int undergroundFloors){
        return floors + undergroundFloors;
    }


    /**
     * @getters section
     */
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
