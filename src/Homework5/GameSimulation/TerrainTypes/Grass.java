package Homework5.GameSimulation.TerrainTypes;

public class Grass extends Terrain{
    private double foodCost = 1.0;
    private double waterCost = 1.0;
    private double staminaCost = 1.0;

    @Override
    public String toString(){
        return "Grass";
    }
}
