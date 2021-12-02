package Homework3;
import java.util.Scanner;

// Code by Alex Mariano
// CS 1400
// Professor David Johannsen

public class Nim2 {

    private static int count = 0;
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args){
        count = (int)(Math.random() * 91) + 10;
        System.out.println("The number of marbles in this game is: " + count);
        while (true){
            getUserTurn();
            if (count == 0){
                System.out.println("Ah that's too bad. Good strategy wins...");
                System.exit(0);
            }
            makeTheUserSuffer();
        }
    }

    //Asks user, checks validity, and subtracts the user's input from count.
    private static void getUserTurn(){
        boolean properInput;
        do {
            System.out.println("Please enter the number of marbles you wish to take away (1 - " + count/2 + ").");
            properInput = true;
            if (userInput.hasNextInt()) {
                int userChosenMarbles = userInput.nextInt();
                if (userChosenMarbles >= 1 && (userChosenMarbles <= (count/2) || userChosenMarbles == 1)){
                    count-= userChosenMarbles;
                    if (userChosenMarbles == 1){
                        System.out.println("You took away " + userChosenMarbles + " marble.");
                    } else {
                        System.out.println("You took away " + userChosenMarbles + " marbles.");
                    }
                    System.out.println("The count is now " + count + " marbles.");
                } else {
                    properInput = false;
                }
            } else {
                properInput = false;
            }
            if (!properInput){
                System.out.println("Unexpected user input. Acceptable values: 1 - " + (count / 2) + ".");
            }
            userInput.nextLine();
        } while (!properInput);
    }

    //Does the computer's turn, using optimal strategy.
    //If it lands on an unlucky number, just -1.
    private static void makeTheUserSuffer(){
        int numToRemove = 1;
        if (count > 63){
            numToRemove = count - 63;
        } else if (count > 31 && count <= 62){
            numToRemove = count - 31;
        } else if (count > 15 && count <= 30) {
            numToRemove = count - 15;
        } else if (count > 7 && count <= 14) {
            numToRemove = count - 7;
        }
        switch(count){
            case 6 -> numToRemove = 3;
            case 5 -> numToRemove = 2;
            default -> {}
        }
        if (numToRemove == 1){
            System.out.println("The computer chooses to remove " + numToRemove + " marble.");
        } else {
            System.out.println("The computer chooses to remove " + numToRemove + " marbles.");
        }
        count -= numToRemove;
        System.out.println("The count is now " + count + " marbles.");
        if(count == 0){
            System.out.println("The computer is defeated. Was it strategy or luck?");
            System.exit(0);
        }
    }

    /* Notes
    The mathematical way is probably more efficient than recursion.

    What is a loosing track?
    Turn, Count
    Computer, 2 --> Player, 1, WIN (forced)
    Computer, 3 --> Player, 2 --> Computer, 1, LOOSE
    Computer, 4 --> Player, 3 --> Computer, 2 --> WINk
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

    2 * 7 = 14 is a forced win (computer should land on 14) (Offensive Strategy)
        14 and below, computer should make count = 7
        Above 14, computer should make count = 15.
    2 * 15 = 30, is a forced win (computer should land on 31). (Defensive Strategy)
        30 and below, computer should make count = 15.
        Above 30, computer should make count = 31.
    2 * 31 = 62.
        62 and below, computer should make count = 31.
        Above 62, computer should make count = 63.
     */
}
