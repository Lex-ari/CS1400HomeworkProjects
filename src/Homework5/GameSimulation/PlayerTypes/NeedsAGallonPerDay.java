package Homework5.GameSimulation.PlayerTypes;

public class NeedsAGallonPerDay extends Player{

    private double waterFactor = 2.0;

    @Override
    public double getWaterFactor(){
        return waterFactor;
    }
}
