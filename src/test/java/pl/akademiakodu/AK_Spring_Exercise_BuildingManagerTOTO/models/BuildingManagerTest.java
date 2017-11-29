package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class BuildingManagerTest {

    private static BuildingManager buildingManager;

    @BeforeClass
    public static void start() {
        buildingManager = new BuildingManager();
    }

    @AfterClass
    public static void stop() throws Exception {
        buildingManager = null;
    }

    /**
     * testing proper work of calculating total cost of building based on four key value given by user
     * @throws Exception
     */
    @Test public void testTotalBuildingCostCalculator() throws Exception {
        Building expectedBuilding = new Building(50, 70, 15, 2, 52500,
                8,2,3,2,7,488, 5,15,1952,
                new BigInteger("20222462"), 235590);
        assertEquals(expectedBuilding.toString(),
                buildingManager.totalCostCalculator(50,70,15,2).toString());
    }

    /**
     * testing proper work of calculating elevator need in the building
     * @throws Exception in case of invalid user input
     */
    @Test public void testElevatorNeed() throws Exception {
        assertEquals(buildingManager.needsElevator(3500, 8), 7);
        assertEquals(buildingManager.needsElevator(5200, 25), 10);
        assertEquals(buildingManager.needsElevator(1200, 5), 2);
        assertEquals(buildingManager.needsElevator(20, 0), 0);
        try {
            buildingManager.needsElevator(-5,-4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating total area of the building
     * @throws Exception in case of invalid user input
     */
    @Test public void testAreaCalculator() throws Exception {
        assertEquals(buildingManager.calculateLevelArea(50,70), 3500);
        try {
            buildingManager.calculateLevelArea(10,-4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating straits need in the building
     * @throws Exception in case of invalid user input
     */
    @Test public void testStraitsNeed() throws Exception {
        assertEquals(buildingManager.needsStraits(3500, 8), 4);
        assertEquals(buildingManager.needsStraits(1200, 5), 1);
        assertEquals(buildingManager.needsStraits(4500, 33), 6);
        assertEquals(buildingManager.needsStraits(880, 0), 0);
        assertEquals(buildingManager.needsStraits(200, 3), 1);
        assertEquals(buildingManager.needsStraits(10, 1), 1);
        try {
            buildingManager.needsStraits(345,-1);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try {
            buildingManager.needsStraits(0,4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating toilets need in the building
     * @throws Exception in case of invalid user input
     */
    @Test public void testToiletNeed() throws Exception {
        assertEquals(buildingManager.needsToilets(61), 18);
        assertEquals(buildingManager.needsToilets(220), 66);
        assertEquals(buildingManager.needsToilets(4), 1);
        assertEquals(buildingManager.needsToilets(13), 3);
        try {
            buildingManager.needsToilets(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating maximum capacity of worker in the building based on given law
     * @throws Exception in case of invalid user input
     */
    @Test public void testPotentialWorker() throws Exception {
        assertEquals(buildingManager.potentialWorkers(61), 244);
        assertEquals(buildingManager.potentialWorkers(220), 880);
        assertEquals(buildingManager.potentialWorkers(4), 16);
        assertEquals(buildingManager.potentialWorkers(13), 52);
        try {
            buildingManager.potentialWorkers(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating room capacity in the building
     * @throws Exception in case of invalid user input
     */
    @Test public void testRoomCalculator() throws Exception {
        assertEquals(buildingManager.roomCalculator(3500, 6, 2, 2), 62);
        assertEquals(buildingManager.roomCalculator(2000, 8, 4, 4), 31);
        assertEquals(buildingManager.roomCalculator(240, 1, 1, 1), 3);
        assertEquals(buildingManager.roomCalculator(100, 0, 1, 0), 1);
        try {
            buildingManager.roomCalculator(0,4, 5, 5);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try {
            buildingManager.roomCalculator(450,-20, 2, 0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating parking need in the building
     * @throws Exception in case of invalid user input
     */
    @Test public void testParkingLevelNeed() throws Exception {
        assertEquals(buildingManager.needsParkingLevel(8), 1);
        assertEquals(buildingManager.needsParkingLevel(2), 0);
        assertEquals(buildingManager.needsParkingLevel(15), 2);
        try {
            buildingManager.needsParkingLevel(-4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating service level need in the building
     * @throws Exception in case of invalid user input
     */
    @Test public void testServiceLevelNeed() throws Exception {
        assertEquals(buildingManager.needsServiceLevel(8), 1);
        assertEquals(buildingManager.needsServiceLevel(2), 0);
        assertEquals(buildingManager.needsServiceLevel(15), 3);
        try {
            buildingManager.needsServiceLevel(-1);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating gastro level need in the building
     * @throws Exception in case of invalid user input
     */
    @Test public void testGastroLevelNeed() throws Exception {
        assertEquals(buildingManager.needGastroLevel(8), 1);
        assertEquals(buildingManager.needGastroLevel(2), 0);
        assertEquals(buildingManager.needGastroLevel(15), 2);
        try {
            buildingManager.needGastroLevel(-123);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

}