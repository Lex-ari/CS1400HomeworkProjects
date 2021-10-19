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
        runSaleTerminal();
    }

    // Lets user decide what they'd like to do
    private static void runSaleTerminal() throws IOException {
        while(true){
            System.out.println("Admin: Please type in action: add, printSales, printTotal, quit");
            switch(userInput.nextLine().toLowerCase()){
                case "add", "add sale", "addsale" -> addSales();
                case "printsales", "print sales", "sales" -> printSales();
                case "printtotal", "print total", "total" -> printTotal();
                case "quit", "terminate", "exit" -> {
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
        boolean receivedImproperInput = false;
        boolean allSalesCompleted = false;
        do { // loop to continuously add sales
            do { // loop to fix current sale
                while (true) { // loop to enter current sale.
                    System.out.println("Please enter the sale amount");
                    if (userInput.hasNextDouble()) {
                        newSale = userInput.nextDouble();
                        // Testing: System.out.println(newSale  * 100 % 1);
                        if ((newSale * 100)% 1 > 0){
                            System.out.println("Caution: Sale will be rounded DOWN to 100th's place!!");
                            newSale = (int)(newSale * 100) * 0.01;
                        }
                        break;
                    } else {
                        System.out.println("Unexpected input. Please enter a sale in the format of 000.00 without a '$' symbol.");
                        userInput.nextLine();
                    }
                }
                do { // loop to confirm current sale
                    receivedImproperInput = false;
                    System.out.printf("New Current Sale: %.2f%n", newSale);
                    System.out.println("Is this sale correct? Y/N");
                    userInput.nextLine();
                    switch (userInput.nextLine().toLowerCase()) {
                        case "y", "yes", "true" -> saleCompleted = true;
                        case "n", "no", "false" -> System.out.println("Restarting process");
                        default -> {
                            System.out.println("Unexpected input, please try again");
                            receivedImproperInput = true;
                        }
                    }
                } while (receivedImproperInput);
            } while (!saleCompleted);
            outputFile.println(newSale);
            System.out.println("Successfully added new sale: " + newSale);
            do { // loop to ask user if they'd like to add another sale
                receivedImproperInput = false;
                System.out.println("Add new sale? Y/N");
                switch (userInput.nextLine().toLowerCase()) {
                    case "y", "yes", "true" -> {} //do nothing
                    case "n", "no", "false" -> {
                        System.out.println("Terminating addSales process...");
                        allSalesCompleted = true;
                    }
                    default -> {
                        System.out.println("Unexpected input, please try again");
                        receivedImproperInput = true;
                    }
                }
            } while (receivedImproperInput);
        } while (!allSalesCompleted);
        outputFile.close();
    }

    //Loops through sales.txt and prints all sales.
    private static void printSales() throws FileNotFoundException {
        if (myFile.exists()) {
            Scanner fileScanner = new Scanner(myFile);
            System.out.println("PrintSales Selected");
            while (fileScanner.hasNextDouble()) {
                System.out.printf("$%.2f%n", fileScanner.nextDouble());
            }
            System.out.println("End Of Sales");

        } else {
            System.out.println("Error: Sales.txt file does not exist!");
            System.out.println("Please add a sale in order to create it.");
        }
        System.out.println();
    }

    //loops sales.txt and adds up numbers
    private static void printTotal() throws FileNotFoundException {
        if (myFile.exists()) {
            Scanner fileScanner = new Scanner(myFile);
            System.out.println("PrintTotal Selected");
            double total = 0.0;
            while (fileScanner.hasNextDouble()) {
                total += fileScanner.nextDouble();
            }
            System.out.printf("Total Sales: $%.2f%n", total);
        } else {
            System.out.println("Error: Sales.txt file does not exist!");
            System.out.println("Please add a sale in order to create it.");
        }
        System.out.println();
    }
}
