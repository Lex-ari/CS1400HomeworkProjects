package Homework3;
import java.util.Scanner;

// Code by Alex Mariano
// CS 1400
// Professor David Johannsen

public class NimRecursive {

    private static int count = 10;
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
            System.out.println("Please enter the number of marbles you wish to take away.");
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
                userInput.nextLine();
            }
        } while (!properInput);
    }

    private static void makeTheUserSuffer(){
        int computerRemoveMarbles = returnForcibleWin();
        System.out.println("The computer chooses to remove " + computerRemoveMarbles + " marbles");
        count -= computerRemoveMarbles;
        System.out.println("The count is now " + count + " marbles");
        if(count == 0){
            System.out.println("The computer is defeated. Strategy, or luck?");
            System.exit(0);
        }
    }

    //gets the number that the computer takes away from count through optimal strategy
    private static int returnForcibleWin(){
        for (int i = 1; i <= count/2; i++){
            if(!isForcibleWinPathRec(count - i, true)){ //if subtracting i gives a chance that the user wins.
                return i;
            }
        }
        return 1; //essentially, player can force win, but just remove 1 in hopes that they will fail.
    }

    //Recursion because it is fun.
    //If the value of 1 reaches the computer's turn, return false;
    //If the value of 1 reaches the player's turn, return true;
    //If it is the computer's turn and there is a true segment, return true;
    //If it is the player's turn and there is at least one false segment, return false;
    //Largely inefficient, since it takes much longer than O(1) when using regular if pattern statements.
    private static boolean isForcibleWinPathRec(int a, boolean isComputer){
        if (a == 1) {
            if (isComputer)
                return false;
            return true;
        }
        for (int i = 1; i <= a/2; i++){ //Cycle through possible subtractions starting from 1.
            boolean tempResult = isForcibleWinPathRec(a-i, !isComputer);
            if (isComputer && tempResult) {
                return true; // Computer's turn, found a path that lets the computer win.
            } else if(!isComputer && !tempResult){
                return false; // Player's turn, found a path that lets the player win.
            }
        }
        //Computer's turn, no paths let the computer win --> Return False;
        //Player's turn, the computer wins all paths. --> Return true
        if (isComputer)
            return false;
        return true;
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

    2 * 7 = 14, 14 is a forced win
        COM must attempt to reach 14 to then give the player 7.
    2 * 14 = 28, which should also be a forced loss
        If a player receives between 29-56, computer can subtract to get 28.
    2 * 28 = 56, which should also be a forced loss
    2 * 56 = 112, which should also be a forced loss

     */
}
