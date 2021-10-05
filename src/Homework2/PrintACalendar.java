package Homework2;

import java.util.Scanner;

//Code by Alex Mariano
// CS1300
// David Johannsen

public class PrintACalendar {
    private static Scanner userKeyboard = new Scanner(System.in);

    private static int numDays = 0;
    private static final int DAYS_OF_WEEK = 0;
    private static int startingDay = -1; //Sunday starts at 0, Saturday is 6

    public static void main(String[] args){
        getUserInput();
        printACalender();
    }

    private static void getUserInput(){
        while (true){
            System.out.print("Enter number of days in a month: ");
            if (userKeyboard.hasNextInt()) {
                numDays = userKeyboard.nextInt();
                break;
            }
            if (numDays == 0){
                System.out.println("Unexpected input, please try again");
                userKeyboard.nextLine();
            }
        }
        System.out.println("User finalized input: " + numDays);
        while (true){
            System.out.print("Enter starting day (acceptable inputs: \"0\", \"Sun\", \"Sunday\": ");
            switch (userKeyboard.next().toLowerCase()){
                case "1", "mon", "monday" -> startingDay = 1;
                case "2", "tue", "tuesday" -> startingDay = 2;
                case "3", "wed", "wednesday" -> startingDay = 3;
                case "4", "thu", "thursday" -> startingDay = 4;
                case "5", "fri", "friday" -> startingDay = 5;
                case "6", "sat", "saturday" -> startingDay = 6;
                case "0", "sun", "sunday" -> startingDay = 0;
                default -> {
                    startingDay = -1;
                    break;
                }
            }
            if (startingDay == -1){
                System.out.println("Unexpected input, please try again");
                userKeyboard.nextLine();
            } else {
                break;
            }
        }
        System.out.println("User finalized input: " + startingDay);
    }

    private static void printACalender() {
        System.out.println("Su  M  T  W Th  F Sa");
        int dayNumber = -startingDay;
        for (int a = 0; a <= (numDays + startingDay - 1) / 7; a++){ // a represents current line
            for (int b = 0; b < 7 && dayNumber < numDays; b++){ // b represents current day;
                dayNumber++;
                if (dayNumber > 0){
                    System.out.printf("%2d ", dayNumber);
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}

