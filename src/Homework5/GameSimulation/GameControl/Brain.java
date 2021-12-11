package Homework5.GameSimulation.GameControl;

import Homework5.GameSimulation.PlayerTypes.*;

public class Brain { // specifically 0 iq brain

    private Player playerType;
    private int yCood;
    private int xCood;
    private boolean isAlive = true;
    private boolean winner = false;
    private String name;
    private static int numPlayers = 0;

    private boolean[][] trail = new boolean[Map.getMapHeight()][Map.getMapLength()];

    public Brain(){
        numPlayers++;
        name = "COM " + numPlayers;
    }

    public Brain(Player playerType) throws Exception {
        numPlayers++;
        name = "COM " + numPlayers;
        this.playerType = new Player(playerType);
    }

    public String getBrainType(){
        return "Brain";
    }

    public boolean getValueAtTrail(int y, int x){
        return trail[y][x];
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

            isAlive = playerType.enter(Map.getTerrainAtCoordinates(yCood, xCood));

            if (!isAlive) { // Alert the Main process that the player died.

                System.out.println("\n####################\n####################\n");
                System.out.println(name + " has died. Following report:");
                System.out.println(this);
                System.out.println("\n####################\n####################\n");
            }
            checkForWin();
        }
    }

    private void checkForWin(){
        int mapLength = Map.getMapLength();
        if(xCood >= mapLength - 1){
            winner = true;
            System.out.println("This player won!"); // also not so specific, will change.
        }
    }

    @Override
    public String toString(){
        return "Name: " + name + "\nBrain type: " + getBrainType() + "\nPlayerType: " + playerType.toString() + "\nPosition: Y" + yCood + " X" + xCood + "\nOn Terrain: " + Map.getTerrainAtCoordinates(yCood, xCood).toString();
    }


}