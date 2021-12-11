package Homework5.GameSimulation;

import Homework5.GameSimulation.GameControl.*;
import Homework5.GameSimulation.PlayerTypes.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Map.initializeMap();
        Brain firstPlayer = new ComplexBrain(new Player());
        Brain secondPlayer = new OmegaBrain(new BornRunner());

        for (int a = 0; a < 55; a++){
            try{
                firstPlayer.move();
                secondPlayer.move();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

}
