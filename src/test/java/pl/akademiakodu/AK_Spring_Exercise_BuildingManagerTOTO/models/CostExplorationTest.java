package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CostExplorationTest {

    private static CostExploration costExploration;

    @BeforeClass public static void start() {
        costExploration = new CostExploration();
    }

    @AfterClass public static void stop() throws Exception {
        costExploration = null;
    }

    /**
     * testing proper work of calculating area tax
     * @throws Exception in case of invalid user input
     */
    @Test public void testTaxPerMeterArea() throws Exception {
        assertEquals(costExploration.calcTaxPerMeterArea(28000), 14000);
        assertEquals(costExploration.calcTaxPerMeterArea(9520), 4760);
        assertEquals(costExploration.calcTaxPerMeterArea(120), 60);
        try {
            costExploration.calcTaxPerMeterArea(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating toilets monthly charges
     * @throws Exception in case of invalid user input
     */
    @Test public void testChargesMonthlyPerToilet() throws Exception {
        assertEquals(costExploration.calcChargesMonthlyPerToilet(48), 11520);
        assertEquals(costExploration.calcChargesMonthlyPerToilet(21), 5040);
        assertEquals(costExploration.calcChargesMonthlyPerToilet(3), 720);
        try {
            costExploration.calcChargesMonthlyPerToilet(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating elevators monthly charges
     * @throws Exception in case of invalid user input
     */
    @Test public void testChargesMonthlyPerElevator() throws Exception {
        assertEquals(costExploration.calcChargesMonthlyPerElevator(6), 11232);
        assertEquals(costExploration.calcChargesMonthlyPerElevator(24), 44928);
        assertEquals(costExploration.calcChargesMonthlyPerElevator(0), 0);
        try {
            costExploration.calcChargesMonthlyPerElevator(-7);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating level area monthly charges
     * @throws Exception in case of invalid user input
     */
    @Test public void testChargesMonthlyPerAreaMeter() throws Exception {
        assertEquals(costExploration.calcChargesMonthlyPerAreaMeter(28000), 16800);
        assertEquals(costExploration.calcChargesMonthlyPerAreaMeter(9520), 5712);
        assertEquals(costExploration.calcChargesMonthlyPerAreaMeter(120), 72);
        try {
            costExploration.calcChargesMonthlyPerAreaMeter(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating media monthly charges
     * @throws Exception in case of invalid user input
     */
    @Test public void testChargesMonthlyMedia() throws Exception {
        assertEquals(costExploration.calcChargesMonthlyMedia(28000), 61600);
        assertEquals(costExploration.calcChargesMonthlyMedia(9520), 20944);
        assertEquals(costExploration.calcChargesMonthlyMedia(120), 264);
        try {
            costExploration.calcChargesMonthlyMedia(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }
    /**
     * testing proper work of calculating power potential consumption provided by worker per month
     * @throws Exception in case of invalid user input
     */
    @Test public void testChargesMonthlyPowerConsumptionPerWorker() throws Exception {
        assertEquals(costExploration.calcChargesMonthlyPowerConsumptionPerWorker(300), 24900);
        assertEquals(costExploration.calcChargesMonthlyPowerConsumptionPerWorker(123), 10209);
        assertEquals(costExploration.calcChargesMonthlyPowerConsumptionPerWorker(8), 664);
        try {
            costExploration.calcChargesMonthlyPowerConsumptionPerWorker(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating power potential consumption provided by building area per month
     * @throws Exception in case of invalid user input
     */
    @Test public void testChargesMonthlyPowerConsumptionPerMeterArea() throws Exception {
        assertEquals(costExploration.calcChargesMonthlyPowerConsumptionPerMeterArea(28000), 5600);
        assertEquals(costExploration.calcChargesMonthlyPowerConsumptionPerMeterArea(9520), 1904);
        assertEquals(costExploration.calcChargesMonthlyPowerConsumptionPerMeterArea(120), 24);
        try {
            costExploration.calcChargesMonthlyPowerConsumptionPerMeterArea(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating gastro monthly charges
     * @throws Exception in case of invalid user input
     */
    @Test public void testChargesMonthlyGastroPerWorker() throws Exception {
        assertEquals(costExploration.calcChargesMonthlyGastroPerWorker(300), -19500);
        assertEquals(costExploration.calcChargesMonthlyGastroPerWorker(123), -7995);
        assertEquals(costExploration.calcChargesMonthlyGastroPerWorker(8), -520);
        try {
            costExploration.calcChargesMonthlyGastroPerWorker(0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }

    /**
     * testing proper work of calculating total monthly charges
     * @throws Exception in case of invalid user input
     */
    @Test public void testTotalChargesMonthly() throws Exception {
        assertEquals(costExploration.calcTotalChargesMonthly(42, 6,28000, 300), 124712);
        assertEquals(costExploration.calcTotalChargesMonthly(16, 3, 9750, 69), 44823);
        assertEquals(costExploration.calcTotalChargesMonthly(1, 0, 120,8), 804);
        try {
            costExploration.calcTotalChargesMonthly(0, 6,28000, 3000);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try {
            costExploration.calcTotalChargesMonthly(42, 6, 0, 3000);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try {
            costExploration.calcTotalChargesMonthly(42, 6, 28000, 0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
        try {
            costExploration.calcTotalChargesMonthly(42, -6, 28000, 850);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Arguments have to be greater than 0!");
        }
    }
}