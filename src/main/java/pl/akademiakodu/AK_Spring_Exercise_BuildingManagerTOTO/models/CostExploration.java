package pl.akademiakodu.AK_Spring_Exercise_BuildingManagerTOTO.models;

public class CostExploration {

    private double taxPerMeterArea = 0.5;
    private int chargesMonthlyPerToilet = 240;
    private int chargesMonthlyPerElevator = 1872;
    private double chargesMonthlyPerAreaMeter = 0.6;
    private double chargesMonthlyMediaPerAreaMeter = 2.2;
    private int chargesMonthlyPowerConsumptionPerWorker = 83;
    private double chargesMonthlyPowerConsumptionPerMeterArea = 0.2;
    private int chargesMonthlyGastroPerWorker = -65;

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

    public int calcTaxPerMeterArea(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getTaxPerMeterArea());
    }

    public int calcChargesMonthlyPerToilet(int toilets){
        if (toilets<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return toilets * getChargesMonthlyPerToilet();
    }

    public int calcChargesMonthlyPerElevator(int elevators){
        if (elevators<0){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return elevators==0 ? 0 : elevators * getChargesMonthlyPerElevator();
    }

    public int calcChargesMonthlyPerAreaMeter(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getChargesMonthlyPerAreaMeter());
    }

    public int calcChargesMonthlyMedia(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getChargesMonthlyMediaPerAreaMeter());
    }

    public int calcChargesMonthlyPowerConsumptionPerWorker(int totalWorkers){
        if (totalWorkers<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return totalWorkers * getChargesMonthlyPowerConsumptionPerWorker();
    }

    public int calcChargesMonthlyPowerConsumptionPerMeterArea(int totalBuildingArea){
        if (totalBuildingArea<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return (int)(totalBuildingArea * getChargesMonthlyPowerConsumptionPerMeterArea());
    }

    public int calcChargesMonthlyGastroPerWorker(int totalWorkers){
        if (totalWorkers<1){
            throw new IllegalArgumentException("Arguments have to be greater than 0!");
        }
        return totalWorkers * getChargesMonthlyGastroPerWorker();
    }

    //Getters
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
