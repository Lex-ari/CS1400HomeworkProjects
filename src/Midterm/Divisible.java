package Midterm;
import java.util.Scanner;

//Code by Alex Mariano
//CS1300
//David Johannsen

public class Divisible {

    private static Scanner userInput = new Scanner(System.in);
    private static int firstNum;
    private static int secondNum;

    public static void main(String[] args){
        getUserNumbers();
        cleanDivisibleOperation();
    }

    private static void getUserNumbers(){
        System.out.println("Enter 1st integer");
        while (true){
            if(userInput.hasNextInt()){
                firstNum = userInput.nextInt();
                break;
            } else {
                System.out.println("Unexpected input. Please enter an integer");
                userInput.nextLine();
            }
        }
        System.out.println("Enter 2nd integer");
        while (true){
            if(userInput.hasNextInt()){
                secondNum = userInput.nextInt();
                break;
            } else {
                System.out.println("Unexpected input. Please enter an integer");
                userInput.nextLine();
            }
        }
        System.out.println("Selected Inputs: " + firstNum + " " + secondNum);
    }

    private static void cleanDivisibleOperation(){
        if (secondNum == 0){ //Note: Be sure to handle div by 0.
            System.out.println("Can't divide by 0");
        }
        if (firstNum % secondNum == 0){ // cleanly divisble
            System.out.println(firstNum + " is evenly divisible by " + secondNum + " with 0 remainder.");
        } else {
            System.out.println(firstNum + " is divisible by " + secondNum + " with " + firstNum % secondNum + " remainder.");
        }
    }


}
