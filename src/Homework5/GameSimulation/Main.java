package Homework5.GameSimulation;

import Homework5.GameSimulation.GameControl.*;
import Homework5.GameSimulation.PlayerTypes.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean activeGame = true;
        boolean reachedEnd = false;
        Map.initializeMap();
        MapPrinter.initializeMapPrinter();
        Brain firstPlayer = new ComplexBrain(new Player());
        Brain secondPlayer = new OmegaBrain(new BornRunner());
        Brain thirdPlayer = new TwoBrainCellsBrain(new NeedsAGallonPerDay());

        Brain[] players = {firstPlayer, secondPlayer, thirdPlayer};

        Scanner scanner = new Scanner(System.in);

        int turn = 0;

        while (activeGame){
            System.out.println("Turn " + turn + "\n");
            activeGame = false;
            for (int x = 0; x < players.length; x++){
                players[x].move();

                if (players[x].isWinner()) {
                    activeGame = false;
                    reachedEnd = true;
                    System.out.println(players[x] + "\n");
                } else if (!players[x].isAlive()){
                    System.out.println(players[x] + "\n");
                } else {
                    activeGame = true;
                    System.out.println(players[x] + "\n");
                }
            }
            MapPrinter.printMap(players);
            System.out.println("Please enter any key in the terminal to advance 1 turn");
            if(scanner.hasNextLine()){
                turn++;
                scanner.next();
            }
        }

        if(!reachedEnd){
            System.out.println("All players have died as of turn " + (turn - 1) + ".");
        } else {
            System.out.println("A player reached the end of the map.");
        }

        int longestLength = 0;
        Brain winner = null;
        for (int x = 0; x < players.length; x++){
            if (players[x].getXCood() > longestLength){
                longestLength = players[x].getXCood();
                winner = players[x];
            }
        }

        System.out.println(winner.getName() + " has won the game with a distance of " + winner.getXCood() + " from the start of the map");
        System.out.println(winner);
        System.out.println();
        System.out.println("Thank you for playing");
    }

}
