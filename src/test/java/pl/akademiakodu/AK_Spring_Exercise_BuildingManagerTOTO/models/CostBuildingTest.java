package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models;

/**
 * Imports section
 */
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.services.CostBuilding;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class CostBuildingTest {

    private static CostBuilding costBuilding;

    @BeforeClass public static void start() {
        costBuilding = new CostBuilding();
    }

    @AfterClass public static void stop() throws Exception {
        costBuilding = null;
    }

    /**
     * testing proper work of calculating foundation cost
     * @throws Exception in case of invalid user input
     */
    @Test public void testCostFoundation() throws Exception {
        assertEquals(costBuilding.calcCostOfFoundation(3500, 8), 722369);
        assertEquals(costBuilding.calcCostOfFoundation(2400, 12), 1027134);
        assertEquals(costBuilding.calcCostOfFoundation(400, 5), 47775);
        assertEquals(costBuilding.calcCostOfFoundation(200, 3), 16588);
        try{
            costBuilding.calcCostOfFoundation(0, 12);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostOfFoundation(555, -2);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        assertEquals(costBuilding.calcCostOfFoundation(120, 0), 4800);
    }

    /**
     * testing proper work of calculating building level area
     * @throws Exception in case of invalid user input
     */
    @Test public void testBuildingArea() throws Exception {
        assertEquals(costBuilding.calcBuildingArea(3500), 4200);
        assertEquals(costBuilding.calcBuildingArea(420), 504);
        try{
            costBuilding.calcBuildingArea(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcBuildingArea(950000);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
    }

    /**
     * testing proper work of calculating ground cost
     * @throws Exception in case of invalid user input
     */
    @Test public void testGroundCost() throws Exception {
        assertEquals(costBuilding.calcCostOfGround(4200), 6300000);
        assertEquals(costBuilding.calcCostOfGround(504), 756000);
        assertEquals(costBuilding.calcCostOfGround(1600), 2400000);
        assertEquals(costBuilding.calcCostOfGround(225), 337500);
        try{
            costBuilding.calcCostOfGround(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating environmental cost
     * @throws Exception in case of invalid user input
     */
    @Test public void testCostOfEnvironment() throws Exception {
        assertEquals(costBuilding.calcCostOfEnvironmentLevel(8), 19200);
        assertEquals(costBuilding.calcCostOfEnvironmentLevel(25), 60000);
        assertEquals(costBuilding.calcCostOfEnvironmentLevel(0), 0);
        try{
            costBuilding.calcCostOfEnvironmentLevel(-5);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostOfEnvironmentLevel(950000);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
    }

    /**
     * testing proper work of calculating roof cost
     * @throws Exception in case of invalid user input
     */
    @Test public void testCostOfRoof() throws Exception {
        assertEquals(costBuilding.calcCostOfRoof(3500), 315000);
        assertEquals(costBuilding.calcCostOfRoof(225), 20250);
        assertEquals(costBuilding.calcCostOfRoof(2400), 216000);
        try{
            costBuilding.calcCostOfRoof(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostOfRoof(950000);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
    }

    /**
     * testing proper work of calculating electronic cost
     * @throws Exception in case of invalid user input
     */
    @Test public void testCostOfElectronic() throws Exception {
        assertEquals(costBuilding.calcCostOfElectronic(3500), 455000);
        assertEquals(costBuilding.calcCostOfElectronic(225), 29250);
        assertEquals(costBuilding.calcCostOfElectronic(2400), 312000);
        try{
            costBuilding.calcCostOfElectronic(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostOfElectronic(950000);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
    }

    /**
     * testing proper work of calculating installation cost
     * @throws Exception in case of invalid user input
     */
    @Test public void testCostOfInstallation() throws Exception {
        assertEquals(costBuilding.calcCostOfInstallation(3500), 66500);
        assertEquals(costBuilding.calcCostOfInstallation(225), 4275);
        assertEquals(costBuilding.calcCostOfInstallation(2400), 45600);
        try{
            costBuilding.calcCostOfInstallation(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostOfInstallation(950000);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
    }

    /**
     * testing proper work of calculating material cost of one floor
     * @throws Exception in case of invalid user input
     */
    @Test public void testCostMaterialFloor() throws Exception {
        assertEquals(costBuilding.calcCostMaterialFloor(3500), 140000);
        assertEquals(costBuilding.calcCostMaterialFloor(225), 9000);
        assertEquals(costBuilding.calcCostMaterialFloor(2400), 96000);
        try{
            costBuilding.calcCostMaterialFloor(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostMaterialFloor(950000);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
    }

    /**
     * testing proper work of calculating walls cost of one floor
     * @throws Exception in case of invalid user input
     */
    @Test public void testCostMaterialAreaWalls() throws Exception {
        assertEquals(costBuilding.calcCostMaterialAreaWalls(70, 50, 8), 99840);
        assertEquals(costBuilding.calcCostMaterialAreaWalls(12,12, 3), 7488);
        assertEquals(costBuilding.calcCostMaterialAreaWalls(50,40,12), 112320);
        try{
            costBuilding.calcCostMaterialAreaWalls(80, 0,8);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostMaterialAreaWalls(0, 40,3);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostMaterialAreaWalls(80, -5,0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcCostMaterialAreaWalls(8000, 500,0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
        try{
            costBuilding.calcCostMaterialAreaWalls(80, 50,80);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
        assertEquals(costBuilding.calcCostMaterialAreaWalls(70,20,0), 9360);
    }

    /**
     * testing proper work of calculating scalable underground cost
     * @throws Exception in case of invalid user input
     */
    @Test public void testTotalCostUndergroundLevel() throws Exception {
        assertEquals(costBuilding.calcTotalCostUndergroundLevel(50, 70,2), 833583);
        assertEquals(costBuilding.calcTotalCostUndergroundLevel(40, 20,5), 7076245);
        assertEquals(costBuilding.calcTotalCostUndergroundLevel(65, 95, 7), 1270286647);
        try{
            costBuilding.calcTotalCostUndergroundLevel(20,20,-4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcTotalCostUndergroundLevel(20,-20,4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcTotalCostUndergroundLevel(-20,20,4);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcTotalCostUndergroundLevel(8000, 5000,8);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
        try{
            costBuilding.calcTotalCostUndergroundLevel(8, 5,24);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
        assertEquals(costBuilding.calcTotalCostUndergroundLevel(12, 10,0), 0);
    }

    /**
     * testing proper work of calculating total cost of building
     * @throws Exception in case of invalid user input
     */
    @Test public void testTotalCostOfBuilding() throws Exception {
        assertEquals(costBuilding.calcTotalCostOfBuilding(50, 70,8, 2), new BigInteger("13621792"));
        assertEquals(costBuilding.calcTotalCostOfBuilding(40, 20,5, 1), new BigInteger("2537211"));
        assertEquals(costBuilding.calcTotalCostOfBuilding(65, 95, 21, 4), new BigInteger("62827662"));
        try{
            costBuilding.calcTotalCostOfBuilding(20,20,4, -2);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcTotalCostOfBuilding(20,20,-4, 2);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcTotalCostOfBuilding(20,-20,4, 2);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcTotalCostOfBuilding(-20,20,4, 2);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try{
            costBuilding.calcTotalCostOfBuilding(200,200,24, 5);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
        try{
            costBuilding.calcTotalCostOfBuilding(20,20,78, 2);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
        try{
            costBuilding.calcTotalCostOfBuilding(20,20,1, 25);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
        try{
            costBuilding.calcTotalCostOfBuilding(2000,200,4, 2);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments over limits!");
        }
        assertEquals(costBuilding.calcTotalCostOfBuilding(12, 10,1,0), new BigInteger("296080"));
    }
}