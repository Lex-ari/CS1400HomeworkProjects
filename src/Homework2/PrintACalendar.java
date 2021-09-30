package Homework2;

import java.util.Scanner;

//Code by Alex Mariano
// CS1300
// David Johannsen

public class PrintACalendar {
    private static Scanner userKeyboard = new Scanner(System.in);

    private static int numDays = 0;
    private static int dayOfWeek = 0;

    public static void main(String[] args){
        getUserInput();


    }

    private static void getUserInput(){
        while (true){
            System.out.print("Enter number of days in a month:");
            if (userKeyboard.hasNextInt()) {
                numDays = userKeyboard.nextInt();
                break;
            } else {
                System.out.println("Unexpected reply, please try again");
                userKeyboard.nextLine();
            }
        }
        System.out.println("User finalized input: " + numDays);

    }
}
