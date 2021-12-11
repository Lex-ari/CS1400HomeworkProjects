package Homework5.GameSimulation.TerrainTypes;

/*
Code by Alex Mariano
CS1400
Professor David Johannsen
Thank you for my first semester!
 */

public class River extends Terrain{

    private double foodCost = 1.0;
    private double waterCost = -1.0;
    private double staminaCost = 1.0;

    @Override
    public double getWaterCost() {
        return waterCost;
    }

    @Override
    public String toString(){
        return "River";
    }
}
