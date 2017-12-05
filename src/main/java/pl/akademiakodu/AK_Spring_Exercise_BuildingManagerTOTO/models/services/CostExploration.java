package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models.services;

/**
 * Imports section
 */
import org.springframework.stereotype.Service;

/**
 * Service responsible for calculate cost of later exploration of building.
 */
@Service
public class CostExploration {

    /**
     * Exploration cost variable holders, example of real costs specified in specific period of time.
     */
    private final double taxPerMeterArea = 0.5;
    private final int chargesMonthlyPerToilet = 240;
    private final int chargesMonthlyPerElevator = 1872;
    private final double chargesMonthlyPerAreaMeter = 0.6;
    private final double chargesMonthlyMediaPerAreaMeter = 2.2;
    private final int chargesMonthlyPowerConsumptionPerWorker = 83;
    private final double chargesMonthlyPowerConsumptionPerMeterArea = 0.2;
    private final int chargesMonthlyGastroPerWorker = -65;

    /**
     * Methods calculate cost of total monthly charges
     * @param totalToilets as a part of noticeable building cost
     * @param totalElevators as a part of noticeable building cost
     * @param totalBuildingArea one of most important exploration cost, key value
     * @param totalWorkers one of most important exploration cost, key value
     * @return combine total cost of every minor calculations
     */
    public int calcTotalChargesMonthly(int totalToilets, int totalElevators, int totalBuildingArea, int totalWorkers){
        int totalChargesMonthly = 0;
        totalChargesMonthly+=calcTaxPerMeterArea(totalBuildingArea);
        totalChargesMonthly+=calcChargesMonthlyPerToilet(totalToilets);
        totalChargesMonthly+=calcChargesMonthlyPerElevator(totalElevators);
        totalChargesMonthly+=calcChargesMonthlyPerAreaMeter(totalBuildingArea);
        totalChargesMonthly+=calcChargesMonthlyMedia(totalBuildingArea);
        totalChargesMonthly+=calcChargesMonthlyPowerConsumptionPerWorker(totalWorkers);
        totalChargesMonthly+=calcChargesMonthlyPowerConsumptionPerMeterArea(totalBuildingArea);
        totalChargesMonthly+=calcChargesMonthlyGastroPerWorker(totalWorkers);
        return totalChargesMonthly;
    }

    /**
     * Methods calculate cost of tas per meter area
     * @param totalBuildingArea given square meter space of the building
     * @return cost of potential tax result of building area
     */
    public int calcTaxPerMeterArea(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getTaxPerMeterArea());
    }

    /**
     * Methods calculate cost of all toilets in the building
     * @param toilets given toilets in the building
     * @return cost of potential using area
     */
    public int calcChargesMonthlyPerToilet(int toilets){
        if (toilets<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return toilets * getChargesMonthlyPerToilet();
    }

    /**
     * Methods calculate cost of elevators
     * @param elevators given elevators in the building
     * @return cost of potential using area
     */
    public int calcChargesMonthlyPerElevator(int elevators){
        if (elevators<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return elevators==0 ? 0 : elevators * getChargesMonthlyPerElevator();
    }

    /**
     * Methods calculate cost of monthly charges per area meter
     * @param totalBuildingArea given square meter space of the building
     * @return cost of potential using area
     */
    public int calcChargesMonthlyPerAreaMeter(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getChargesMonthlyPerAreaMeter());
    }

    /**
     * Methods calculate cost of media monthly charges
     * @param totalBuildingArea given square meter space of the building
     * @return cost of potential media
     */
    public int calcChargesMonthlyMedia(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getChargesMonthlyMediaPerAreaMeter());
    }

    /**
     * Methods calculate cost of power consumption charges per worker per month
     * @param totalWorkers given workers, working in the building
     * @return cost of potential power consumption provided by a all workers
     */
    public int calcChargesMonthlyPowerConsumptionPerWorker(int totalWorkers){
        if (totalWorkers<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return totalWorkers * getChargesMonthlyPowerConsumptionPerWorker();
    }

    /**
     * Methods calculate cost of power consumption charges per meter building area per month
     * @param totalBuildingArea given square meter space of the building
     * @return cost of potential power consumption provided by building area
     */
    public int calcChargesMonthlyPowerConsumptionPerMeterArea(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getChargesMonthlyPowerConsumptionPerMeterArea());
    }

    /**
     * Methods calculate cost of monthly gastro level
     * @param totalWorkers given workers, working in the building
     * @return cost of potential charges result of all workers in the building
     */
    public int calcChargesMonthlyGastroPerWorker(int totalWorkers){
        if (totalWorkers<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return totalWorkers * getChargesMonthlyGastroPerWorker();
    }

    /**
     * @Getters section
     */
    public int getChargesMonthlyPerToilet() {
        return chargesMonthlyPerToilet;
    }

    public int getChargesMonthlyPerElevator() {
        return chargesMonthlyPerElevator;
    }

    public double getChargesMonthlyPerAreaMeter() {
        return chargesMonthlyPerAreaMeter;
    }

    public double getChargesMonthlyMediaPerAreaMeter() {
        return chargesMonthlyMediaPerAreaMeter;
    }

    public int getChargesMonthlyPowerConsumptionPerWorker() {
        return chargesMonthlyPowerConsumptionPerWorker;
    }

    public double getChargesMonthlyPowerConsumptionPerMeterArea() {
        return chargesMonthlyPowerConsumptionPerMeterArea;
    }

    public int getChargesMonthlyGastroPerWorker() {
        return chargesMonthlyGastroPerWorker;
    }

    public double getTaxPerMeterArea() {
        return taxPerMeterArea;
    }
}
