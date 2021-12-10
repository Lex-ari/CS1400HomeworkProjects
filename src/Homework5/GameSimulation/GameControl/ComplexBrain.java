package Homework5.GameSimulation.GameControl;

import Homework5.GameSimulation.PlayerTypes.Player;

public class ComplexBrain extends Brain{

    @Override
    public void move() throws Exception {
        double trialNGrade;
        double trialEGrade;
        double trialWGrade;
    }

    private double trialN() throws Exception { // be sure to ensure out of bounds exception
        Player imaginaryPlayer = new Player(getPlayerType());
        imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood() + 1, getXCood()));
        return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
    }

    private double trialE() throws Exception {
        Player imaginaryPlayer = new Player(getPlayerType());
        imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood(), getXCood() + 1));
        return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
    }

    private double trialS() throws Exception {
        Player imaginaryPlayer = new Player(getPlayerType());
        imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood() - 1, getXCood()));
        return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
    }

}
