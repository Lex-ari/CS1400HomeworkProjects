package Homework5.GameSimulation.GameControl;

import Homework5.GameSimulation.PlayerTypes.*;
import Homework5.GameSimulation.TerrainTypes.*;

public class Brain { // specifically 0 iq brain

    private Player playerType;
    private int yCood;
    private int xCood;
    private boolean isAlive = true;
    private Map map;

    public Brain(){

    }

    public void setMap(Map map){
        this.map = map;
    }

    public void setPlayerType(Player playerType){
        this.playerType = playerType;
    }

    public void move(){ // Strategy goes here
        if (!isAlive){
            throw new IllegalArgumentException("Player is dead lol");
        }
        //This is empty. Nobody plays the "brain" class.
    }

    protected void travelToTerrain(String heading){ // No strategy, only move + dead check
        int yDelta = 0;
        int xDelta = 0;

        switch (heading){
            case "N" -> yDelta = 1;
            case "E" -> xDelta = 1;
            case "S" -> yDelta = -1;
            default -> throw new IllegalArgumentException("Obtained value is not a heading!");
        }

        yCood += yDelta;
        xCood += xDelta;

        isAlive = playerType.enter(map.getTerrainAtCoordinates(yCood, xCood));

        if (!isAlive){
            System.out.println("This player died"); // not so specific, will change.
        }
    }
}
