package Homework2;

import java.util.Scanner;

//Code by Alex Mariano

public class RockPaperScissors {
    private static Scanner userInput = new Scanner(System.in);

    private static StringBuilder player1 = new StringBuilder();
    private static StringBuilder player2 = new StringBuilder();
    private static int player1Score = 0;
    private static int player2Score = 0;

    public static void main(String[] args){
        do {
            getUserInput(player1);
            getUserInput(player2);
            System.out.println();
            simulateMatch();
        } while (playAgain());
        //System.out.println(player1);
        //System.out.println(player2);
    }

    private static void simulateMatch(){
        boolean tie = false;
        if (player1.toString().equals(player2.toString())) {
            System.out.println("Match is a tie");
            tie = true;
        }
        if (!tie) {
            switch (player1.toString()) {
                case "Rock":
                    if (player2.equals("Paper")) {
                        System.out.println("Player 2 Wins: Paper covers Rock");
                        player2Score++;
                    } else {
                        System.out.println("Player 1 Wins: Rock smashes Scissors");
                        player1Score++;
                    }
                    break;
                case "Paper":
                    if (player2.equals("Rock")) {
                        System.out.println("Player 1 Wins: Paper covers Rock");
                        player1Score++;
                    } else {
                        System.out.println("Player 2 Wins: Scissors cuts Paper");
                        player2Score++;
                    }
                    break;
                case "Scissors":
                    if (player2.equals("Rock")) {
                        System.out.println("Player 2 Wins: Rock smashes Scissors");
                        player2Score++;
                    } else {
                        System.out.println("Player 1 Wins: Scissors cuts Paper");
                        player1Score++;
                    }
                    break;
                default: // nothing
                    break;
            }
        }
        System.out.printf("Scores: Player 1:%d, Player2:%d%n", player1Score, player2Score);
    }

    private static boolean playAgain(){
        System.out.println("Want to play again? Y/N");
        boolean unExpectedInput;
        do {
            unExpectedInput = false;
            switch (userInput.next().toLowerCase()) {
                case "y" -> {return true;}
                default -> unExpectedInput = true;
            }
        } while (unExpectedInput);
        return false;
    }

    private static void getUserInput(StringBuilder player){
        int playerNumber = 0;
        player.setLength(0);
        if (player1 == player){
            playerNumber = 1;
        } else {
            playerNumber = 2;
        }
        System.out.printf("Player %d, choose R(Rock) P(Paper), or S(Scissors)%n", playerNumber);
        boolean unExpectedInput;
        do {
            unExpectedInput = false;
            switch(userInput.next().toLowerCase()){
                case "r" -> player.append("Rock");
                case "p" -> player.append("Paper");
                case "s" -> player.append("Scissors");
                default -> unExpectedInput = true;
            }
            if (unExpectedInput){
                System.out.println("Unexpected Input, please try again");
                userInput.nextLine();
            }
        } while (unExpectedInput);
        //System.out.println(player);
    }
}
