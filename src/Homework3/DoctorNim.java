package Homework3;
import java.util.Scanner;

// Code by Alex Mariano
// CS 1400
// Professor David Johannsen

public class DoctorNim {

    private static int count = 0;
    private static Scanner userInput = new Scanner(System.in);


    public static void main(String[] args){
        count = (int)(Math.random() * 91) + 10;
        System.out.println("The number of marbles in this game is: " + count);
        while (true){
            getUserTurn();
            System.out.println(count);
        }
    }

    //Asks user, checks validity, and subtracts the user's input from count.
    private static void getUserTurn(){
        boolean properInput;
        do {
            properInput = true;
            if (userInput.hasNextInt()) {
                int userChosenMarbles = userInput.nextInt();
                if (userChosenMarbles >= 1 && userChosenMarbles <= (count/2)){
                    count-= userChosenMarbles;
                } else {
                    properInput = false;
                }
            } else {
                properInput = false;
            }
            if (!properInput){
                System.out.println("Unexpected user input. Acceptable values: 1 - " + (count / 2));
                userInput.nextLine();
            }
        } while (!properInput);
    }

    private static void makeTheUserSuffer(){
        if (count > 7 && count <= 14)



        switch(count){
            case 5 -> count -= 2;
            case 6 -> count -= 3;
            default -> count--;
        }
    }

    //recursion time
    private static boolean isForcibleWinPath(int a){ // the first call of this will assume that the computer is asking
        //need to find a path where
        for (int i = a - 1; i > 1; i--){
            isForcibleWinPath(i); // this is going to flip with possible inputs from both computer and user
        }
        return true;
    }

    /* Notes
    The mathematical way is probably more efficient than recursion.

    What is a loosing track?
    Turn, Count
    Computer, 2 --> Player, 1, WIN (forced)
    Computer, 3 --> Player, 2 --> Computer, 1, LOOSE
    Computer, 4 --> Player, 3 --> Computer, 2 --> WIN
    Computer, 4 --> Player, 2 --> Computer, 1, LOOSE
        If count 4, best move is to take 1.
        Winning numbers: 2, 4

    Computer, 5 --> Player, 4 --> Computer, 3 --> LOOSE
    Computer, 5 --> Player, 3 --> Computer 2 --> WIN
        If count 5, best move is to take 2.
        Winning numbers: 2, 4, 5

    Computer, 6 --> Player, 5 --> LOOSE
    Computer, 6 --> Player, 4 --> WIN
    Computer, 6 --> Player, 3 --> Computer 2 --> WIN
        If count 6, best move is to take 3.
        Winning numbers: 2, 4, 5, 6

    Computer, 7 --> Player, 6 --> LOOSE
    Computer, 7 --> Player, 5 --> LOOSE
    Computer, 7 --> Player, 4 --> LOOSE
        7 IS A FORCED LOSS IF OPPONENT PLAYS EFFECTIVELY. DO NOT RECEIVE A 7. rather give it to them :3
        Winning numbers: 2, 4, 5, 6

    2 * 7 = 14, 14 is a forced win
        COM must attempt to reach 14 to then give the player 7.
    2 * 14 = 28, which should also be a forced loss
        If a player receives between 29-56, computer can subtract to get 28.
    2 * 28 = 56, which should also be a forced loss
    2 * 56 = 112, which should also be a forced loss

     */



}
