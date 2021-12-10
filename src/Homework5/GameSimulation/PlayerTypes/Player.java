package Homework5.GameSimulation.PlayerTypes;

import Homework5.GameSimulation.TerrainTypes.*;

public class Player {

    private double foodSupply;
    private double waterSupply;
    private double staminaSupply;
    private double foodFactor = 1.0;
    private double waterFactor = 1.0;
    private double staminaFactor = 1.0;

    public Player(int foodSupply, int waterSupply, int staminaSupply){
        this.foodSupply = foodSupply;
        this.waterSupply = waterSupply;
        this.staminaSupply = staminaSupply;
    }

    public Player(){
        foodSupply = 20;
        waterSupply = 20;
        staminaSupply = 20;
    }

    public boolean enter(Terrain terrain){
        double food = terrain.getFoodCost();
        if (food > 0.0) {
            food *= getFoodFactor();
        }
        foodSupply -= food;
        if (foodSupply > 20.0){
            foodSupply = 20.0;
        }
        if (foodSupply < 0.0){
            return false;
        }

        double water = terrain.getWaterCost();
        if (water > 0.0) {
            water *= getWaterFactor();
        }
        waterSupply -= water;
        if (waterSupply > 20.0){
            waterSupply = 20.0;
        }
        if (waterSupply < 0.0){
            return false;
        }

        double stamina = terrain.getStaminaCost();
        if (stamina > 0.0){
            stamina *= getStaminaFactor();
        }
        staminaSupply -= stamina;
        if (staminaSupply > 20.0){
            staminaSupply = 20.0;
        }
        if (staminaSupply < 0.0){
            return false;
        }
        return true;
    }

    public double getFoodSupply(){
        return foodSupply;
    }
    public double getWaterSupply(){
        return waterSupply;
    }
    public double getStaminaSupply(){
        return staminaSupply;
    }

    public void setFoodSupply(int foodSupply){
        this.foodSupply = foodSupply;
    }
    public void setWaterSupply(int waterSupply){
        this.waterSupply = waterSupply;
    }
    public void setStaminaSupply(int staminaSupply){
        this.staminaSupply = staminaSupply;
    }

    public double getFoodFactor(){
        return foodFactor;
    }
    public double getWaterFactor(){
        return waterFactor;
    }
    public double getStaminaFactor(){
        return staminaFactor;
    }

}
