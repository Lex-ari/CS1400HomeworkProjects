package Homework5.GameSimulation.TerrainTypes;

public class Sand extends Terrain{

    private double foodCost = 1.0;
    private double waterCost = 1.5;
    private double staminaCost = 1.5;

    @Override
    public double getWaterCost(){
        return waterCost;
    }

    @Override
    public double getStaminaCost(){
        return staminaCost;
    }

    @Override
    public String toString(){
        return "Sand";
    }

}
