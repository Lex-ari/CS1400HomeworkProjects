package Homework5.GameSimulation.PlayerTypes;

public class BornRunner extends Player{
    private double staminaSupply = 0.1;

    @Override
    public double getStaminaFactor(){
        return staminaSupply;
    }
}
