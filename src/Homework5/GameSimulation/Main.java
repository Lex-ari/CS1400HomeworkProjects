package Homework5.GameSimulation;

import Homework5.GameSimulation.TerrainTypes.River;
import Homework5.GameSimulation.TerrainTypes.Terrain;

public class Main {

    public static void main(String[] args){

        Terrain river = new River();
        System.out.println(river.getWaterCost());
    }

}
