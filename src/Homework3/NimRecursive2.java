package Homework3;
import java.util.Arrays;
import java.util.Scanner;

// Code by Alex Mariano
// CS 1400
// Professor David Johannsen

public class NimRecursive2 {

    private static int count = 50;
    private static Scanner userInput = new Scanner(System.in);
    private static int[] truthValues;

    public static void main(String[] args){
        //count = (int)(Math.random() * 91) + 10;
        truthValues = new int[count];
        truthValues[0] = 2;
        System.out.println("The number of marbles in this game is: " + count);
        while (true){
            getUserTurn();
            if (count == 0){
                System.out.println("Ah that's too bad. Good strategy wins...");
                System.exit(0);
            }
            makeTheUserSuffer();
            System.out.println(Arrays.toString(truthValues));
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
            if(isForcibleWinPathRec(count - i, false)){ //should be no turns where the player can win.
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
        //If the number is a safe number, the computer should assume true..
        //Computers turn, return true.
        //Players turn, return false..
        //If the number is not a safe number, should return false.

        if (truthValues[a-1] == 1) { // if a is a safe number, should return true.
            //System.out.println(a + " is a safe number! isComputer: " + isComputer);
            return isComputer;
        } else if(truthValues[a-1] == 2){
            //System.out.println(a + " is not a safe number! isComputer: " + isComputer);
            return !isComputer;
        }
        for (int i = 1; i <= a/2; i++){ //Cycle through possible subtractions starting from 1.
            boolean tempResult = isForcibleWinPathRec(a-i, !isComputer);
            if (isComputer && tempResult) {
                truthValues[a-1] = 1;
                System.out.println("I found that " + a + " is a safe number! isComputer: " + isComputer);
                return true; // Computer's turn, found a path that lets the computer win.
            } else if(!isComputer && !tempResult){
                truthValues[a-1] = 1;
                return false; // Player's turn, found a path that lets the player win.
            }
        }
        //Computer's turn, no paths let the computer win --> Return False;
        //Player's turn, the computer wins all paths. --> Return true
        if (isComputer) {
            truthValues[a-1] = 2;
            return false;
        }
        truthValues[a-1] = 1;
        return true;
    }
}
