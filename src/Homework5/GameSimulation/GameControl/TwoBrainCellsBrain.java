package Homework5.GameSimulation.GameControl;

import Homework5.GameSimulation.PlayerTypes.NeedsAGallonPerDay;
import Homework5.GameSimulation.PlayerTypes.Player;

public class TwoBrainCellsBrain extends Brain{
    public TwoBrainCellsBrain(Player player) throws Exception {
        setPlayerType(player);
    }

    @Override
    public void move() throws Exception {
        travelToTerrain("E"); // no think only move
    }

    @Override
    public String getBrainType(){
        return "TwoBrainCellsBrain";
    }
}
