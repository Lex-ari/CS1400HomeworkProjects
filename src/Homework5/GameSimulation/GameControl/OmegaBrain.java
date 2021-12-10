package Homework5.GameSimulation.GameControl;

import Homework5.GameSimulation.PlayerTypes.Player;

public class OmegaBrain extends Brain{

    @Override
    public void move() throws Exception {
        //double trialNGrade = trialN();
        double trialEGrade = trialE();
        //double trialWGrade = trialS();

        double[] trialResults = {trialNGrade, trialEGrade, trialWGrade};

        double maxVal = -100;
        int maxValPosition = 2; // this is the default,  in case all the paths lead the player to death.
        for (int x = 0; x < trialResults.length; x++){
            if (trialResults[x] > maxVal){
                maxVal = trialResults[x];
                maxValPosition = x;
            }
        }

        switch (maxValPosition){
            case 0 -> travelToTerrain("N");
            case 1 -> travelToTerrain("E");
            case 2 -> travelToTerrain("S");
            default -> throw new Exception("Max Value Position Does Not Match With Any Config");
        }
        //Do an array here, and then act according to position on array.

        //Does the player die on this route?
        //Prioritize balance over most supply?
    }

    private double trialNE() throws Exception { // be sure to ensure out of bounds exception
        try {
            if (getValueAtTrail(getYCood() + 1, getXCood()) && getValueAtTrail(getYCood() + 1, getXCood()+1)){
                return -100; // The player had already passed this section. No going back!
                // this also happens if the "search" goes out of the map
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood() + 1, getXCood()));
            imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood() + 1, getXCood() + 1));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){ // These exceptions also handle array out of bounds on both map and trail
            return -100;
        }
    }

    private double trialE() throws Exception {
        try {
            if (getValueAtTrail(getYCood(), getXCood() + 1)){
                return -100; // The player had already passed this section. No going back!
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood(), getXCood() + 1));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){
            return -100;
        }
    }

    private double trialEN() throws Exception { // be sure to ensure out of bounds exception
        try {
            if (getValueAtTrail(getYCood() + 1, getXCood() + 1) && getValueAtTrail(getYCood(), getXCood() + 1)){
                return -100; // The player had already passed this section. No going back!
                // this also happens if the "search" goes out of the map
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood(), getXCood() + 1));
            imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood() + 1, getXCood() + 1));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){ // These exceptions also handle array out of bounds on both map and trail
            return -100;
        }
    }

    private double trialSE() throws Exception { // be sure to ensure out of bounds exception
        try {
            if (getValueAtTrail(getYCood() - 1, getXCood()) && getValueAtTrail(getYCood() - 1, getXCood() + 1)){
                return -100; // The player had already passed this section. No going back!
                // this also happens if the "search" goes out of the map
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood() - 1, getXCood()));
            imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood() - 1, getXCood() + 1));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){ // These exceptions also handle array out of bounds on both map and trail
            return -100;
        }
    }
    private double trialES() throws Exception { // be sure to ensure out of bounds exception
        try {
            if (getValueAtTrail(getYCood(), getXCood() + 1) && getValueAtTrail(getYCood() - 1, getXCood() + 1)){
                return -100; // The player had already passed this section. No going back!
                // this also happens if the "search" goes out of the map
            }
            Player imaginaryPlayer = new Player(getPlayerType());
            imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood(), getXCood() + 1));
            imaginaryPlayer.enter(getMap().getTerrainAtCoordinates(getYCood() - 1, getXCood() + 1));
            return imaginaryPlayer.getFoodSupply() + imaginaryPlayer.getWaterSupply() + imaginaryPlayer.getStaminaSupply();
        } catch (Exception e){ // These exceptions also handle array out of bounds on both map and trail
            return -100;
        }
    }
}
