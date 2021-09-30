package Homework2;

import java.io.*;
import java.util.Scanner;

//Code by Alex Mariano
//CS1400
//Professor David Johannsen

public class CountEntriesProject {
    //private static Scanner userInput = new Scanner(System.in); UNUSED

    private static File currentFile = new File("src/Homework2/MyFriends.txt");

    public static void main(String[] args) throws IOException {
        System.out.println("Number of entires: " + countEntriesOnCurrentFile());
        System.out.println("Number of entires with first letter A - M: "  +countFirstHalfNames());
    }

    public static int countEntriesOnCurrentFile() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(currentFile);
        int totalEntries = 0;
        int countFirstHalfNames = 0;
        while (fileScanner.hasNext()) {
            totalEntries++;
            fileScanner.nextLine();
        }
        return totalEntries;
    }

    public static int countFirstHalfNames() throws FileNotFoundException {
        int countFirstHalfNames = 0;
        Scanner fileScanner = new Scanner(currentFile);
        while (fileScanner.hasNext() && (int)fileScanner.nextLine().toLowerCase().charAt(0) >= 97 && (int)fileScanner.nextLine().toLowerCase().charAt(0) <= 109) {
            System.out.println("did once");
            countFirstHalfNames++;
            fileScanner.nextLine();
        }
        return countFirstHalfNames;
    }

}
