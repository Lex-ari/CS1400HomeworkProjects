package Homework5.GameSimulation.GameControl;

import Homework5.GameSimulation.PlayerTypes.*;

public class Brain { // specifically 0 iq brain

    private Player playerType;
    private int yCood;
    private int xCood;
    private boolean isAlive = true;
    private boolean winner = false;
    private Map map;
    private String name;

    private boolean[][] trail;

    public Brain(){
    }

    public void setMap(Map map){
        this.map = map;
        yCood = map.getStartingPosition();
        trail = new boolean[map.getMapHeight()][getMap().getMapLength()]; // default values are false
    }

    public boolean getValueAtTrail(int y, int x){
        return trail[y][x];
    }


    public Map getMap(){
        return map;
    }

    public void setPlayerType(Player playerType) throws Exception {
        this.playerType = new Player(playerType);
    }

    public Player getPlayerType() throws Exception {
        return new Player(playerType);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getXCood(){
        return xCood;
    }

    public int getYCood(){
        return yCood;
    }

    public void move() throws Exception { // Strategy goes here
        //This is empty. Nobody plays the "brain" class.
        throw new Exception("Attempted to play Brain Superclass - Not a playable class");
    }

    protected void travelToTerrain(String heading) throws Exception { // No strategy, only move + dead check
        if (isAlive && !winner) {
            int yDelta = 0;
            int xDelta = 0;

            switch (heading) {
                case "N" -> yDelta = 1;
                case "E" -> xDelta = 1;
                case "S" -> yDelta = -1;
                default -> throw new IllegalArgumentException("Obtained value is not a heading!");
            }

            trail[yCood][xCood] = true;
            yCood += yDelta;
            xCood += xDelta;

            isAlive = playerType.enter(map.getTerrainAtCoordinates(yCood, xCood));

            if (!isAlive) {
                System.out.println("This player died"); // not so specific, will change.
            }
            checkForWin();
            System.out.println(this);
        } else {
            throw new Exception("This player is dead");
        }
    }

    private void checkForWin(){
        int mapLength = map.getMapLength();
        if(xCood >= mapLength - 1){
            winner = true;
            System.out.println("This player won!"); // also not so specific, will change.
        }
    }

    @Override
    public String toString(){
        return "PlayerType: \n" + playerType.toString() + "\nPosition: Y" + yCood + " X" + xCood + "\nOn Terrain: " + map.getTerrainAtCoordinates(yCood, xCood).toString();
    }


}
