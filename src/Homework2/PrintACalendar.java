package Homework2;

import java.util.Arrays;
import java.util.Scanner;

//Code by Alex Mariano
// CS1300
// David Johannsen

public class PrintACalendar {
    private static Scanner userKeyboard = new Scanner(System.in);

    private static int numDays = 0;
    private static final int DAYS_OF_WEEK = 0;
    private static int startingDay = -1; //Sunday starts at 0, Saturday is 6
    private static int[] spacing = new int[7];

    public static void main(String[] args){
        getUserInput();
        calculateSpacing();
        //System.out.println(Arrays.toString(spacing));
        printACalender();
    }

    //As name implies, gets user input by asking important questions
    //This sets the values of startingDay and numDays
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

    //Prints all the weeks by printing until it reaches numDays
    private static void printACalender() {
        printHeader();
        int dayNumber = -startingDay;
        for (int a = 0; a <= (numDays + startingDay - 1) / 7; a++){ // a represents current line
            for (int b = 0; b < 7 && dayNumber < numDays; b++){ // b represents current day;
                dayNumber++;
                if (dayNumber > 0){
                    String formatter = "%" + spacing[b] + "d ";
                    System.out.printf(formatter, dayNumber);
                } else {
                    for (int x = 0; x < spacing[b]; x++){
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // This takes spacing of the last week into account
    // Includes minimum spaces, 2 for 1 letter days, 1 for 2 letter days.
    private static void printHeader(){
        for (int day = 0; day < 7; day++){
            int dayDigits = 0;
            for (int x = 0; x < spacing[day] - 2; x++){
                System.out.print(" ");
            }
            switch(day){
                case 0 -> System.out.print("Su");
                case 1 -> System.out.print(" M");
                case 2 -> System.out.print(" T");
                case 3 -> System.out.print(" W");
                case 4 -> System.out.print("Th");
                case 5 -> System.out.print(" F");
                case 6 -> System.out.print("Sa");
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    //Calculates the number of digits for each day of the last week
    //Each col has minimum of 2 spaces.
    private static void calculateSpacing(){
        for (int x = 0; x < 7; x++){
            //starting day = 1
            //numDays = 7, testNumber = 7
            //numDays = 13, testNumber = 7
            //numDays = 14, testNumber = 14

            //starting day = 3
            //numDays = 5, testNumber = 5
            //numDays = 11, testNumber = 5
            //numDays = 12, testNumber = 5

            //starting day = 0
            //numDays = 8, testNumber = 8
            //numDays = 14, testNumber = 8
            //numDays = 15, testNumber = 15

            int testNumber = (numDays + startingDay - 1)/ 7 * 7 + x - startingDay + 1; // calculates the last week's value
            if (testNumber > numDays){
                testNumber -= 7;
            }
            //System.out.println(testNumber);
            int digits = 1;
            while (testNumber / 10 > 0){
                testNumber = testNumber / 10;
                digits++;
            }
            if (digits < 2){
                digits = 2;
            }
            spacing[x] = digits;
        }
    }
}

