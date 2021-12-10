package Homework5.GameSimulation.GameControl;

import Homework5.GameSimulation.PlayerTypes.Player;

public class TwoBrainCellsBrain extends Brain{
    @Override
    public void move(){
        travelToTerrain("E");
    }
}
