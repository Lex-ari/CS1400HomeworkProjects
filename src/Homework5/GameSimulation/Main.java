package Homework5.GameSimulation;

import Homework5.GameSimulation.GameControl.*;
import Homework5.GameSimulation.PlayerTypes.Player;
import Homework5.GameSimulation.TerrainTypes.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Map gameMap = new Map();
        gameMap.initializeMap();
        Brain firstPlayer = new ComplexBrain();
        firstPlayer.setPlayerType(new Player());
        firstPlayer.setMap(gameMap);
        System.out.println(firstPlayer);

        //firstPlayer.move();
        //System.out.println(firstPlayer.toString());

        for (int a = 0; a < 55; a++){
            try{
                firstPlayer.move();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

}
