package Homework5.GameSimulation.TerrainTypes;

public class Forest extends Terrain {

    private double foodCost = -1.0;
    private double waterCost = 1.0;
    private double staminaCost = 2.0;

    @Override
    public double getStaminaCost(){
        return staminaCost;
    }

    @Override
    public String toString(){
        return "Forest";
    }
}
