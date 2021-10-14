package Midterm;
import java.io.*;
import java.util.Scanner;

//Code by Alex Mariano
//CS 1300
//Professor David Johannsen

public class Sales {

    private static Scanner userInput = new Scanner(System.in);
    private static File myFile = new File("sales.txt");

    public static void main(String[] args) throws IOException {
        chooseOption();
    }

    private static void chooseOption() throws IOException {
        while(true){
            System.out.println("Admin: Please type in action: add, printSales, printTotal, quit");
            switch(userInput.nextLine().toLowerCase()){
                case "add" -> addSales();
                case "printsales" -> printSales();
                case "printtotal" -> printTotal();
                case "quit" -> {
                    System.out.println("Thank you for using Alex's Sales Terminal");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Unexpected input, please try again");
                }
            }
        }
    }
    // asks user to enter in sales, confirm it correct, then asks if user wants to add another sale or terminate.
    private static void addSales() throws IOException {
        System.out.println("AddSales Selected");
        FileWriter fWriter = new FileWriter(myFile, true);
        PrintWriter outputFile = new PrintWriter(fWriter);
        double newSale = 0.0;
        boolean saleCompleted = false;
        boolean receivedInProperInput = false;
        boolean allSalesCompleted = false;
        do { // loop to continuously add sales
            do { // loop to fix current sale
                while (true) {
                    System.out.println("Enter the sale amount");
                    if (userInput.hasNextDouble()) {
                        newSale = userInput.nextDouble();
                        if (newSale % 0.01 < 0.01){
                            System.out.println("Caution: Sale will be rounded down to 100th's place");
                            newSale = (int)(newSale / 0.01) * 0.01;
                        }
                        break;
                    } else {
                        System.out.println("Unexpected input.");
                    }
                }
                do {
                    receivedInProperInput = false;
                    System.out.printf("New Current Sale: %.2f%n", newSale);
                    System.out.println("Is this sale correct? Y/N");
                    userInput.nextLine();
                    switch (userInput.nextLine().toLowerCase()) {
                        case "y", "yes", "true" -> saleCompleted = true;
                        case "n", "no", "false" -> System.out.println("Restarting process");
                        default -> {
                            System.out.println("Unexpected input, please try again");
                            receivedInProperInput = true;
                        }
                    }
                } while (receivedInProperInput);
            } while (!saleCompleted);
            outputFile.println(newSale);
            System.out.println("Successfully added new sale: " + newSale);
            do {
                receivedInProperInput = false;
                System.out.println("Add new sale? Y/N");
                switch (userInput.nextLine().toLowerCase()) {
                    case "y", "yes", "true" -> {} //do nothing
                    case "n", "no", "false" -> {
                        System.out.println("Terminating current process...");
                        allSalesCompleted = true;
                    }
                    default -> {
                        System.out.println("Unexpected input, please try again");
                        receivedInProperInput = true;
                    }
                }
            } while (receivedInProperInput);
        } while (!allSalesCompleted);
        outputFile.close();
    }
    private static void printSales() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(myFile);
        System.out.println("PrintSales Selected");
        while (fileScanner.hasNextDouble()){
            System.out.printf("%.2f%n", fileScanner.nextDouble());
        }
        System.out.println("End Of Sales");
        System.out.println();
    }
    private static void printTotal() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(myFile);
        System.out.println("PrintTotal Selected");
        double total = 0.0;
        while (fileScanner.hasNextDouble()){
            total += fileScanner.nextDouble();
        }
        System.out.printf("Total Sales: $%.2f%n", total);
        System.out.println();
    }
}
