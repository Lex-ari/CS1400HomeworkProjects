package Homework5.GameSimulation.TerrainTypes;

public class Snow extends Terrain{
    private double foodCost = 2;
    private double waterCost = 2;
    private double staminaCost = 2;

    @Override
    public double getStaminaCost(){
        return staminaCost;
    }
    @Override
    public double getFoodCost(){
        return foodCost;
    }
    @Override
    public double getWaterCost(){
        return waterCost;
    }

    @Override
    public String toString(){
        return "Snow";
    }

}
