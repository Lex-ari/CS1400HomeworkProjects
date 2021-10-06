package Quizzes;

import java.util.Scanner;

public class Quiz3 {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("User, enter a sentence and i make it funky");
        String userMessage = userInput.nextLine();
        printWeirdly(userMessage);

        //Testing
        //printWeirdly("The quick brown fox jumped over the lazy poodle.");
        //printWeirdly("1L 2EE 3TTT 4TTTT 5EEEEE 6RRRRRR 7SSSSSSS 8.k");
    }

    //Essentially prints the 1st letter on line 1, next 2 letters on line 2, and so on
    //Continues this until the message ends. Does not include spaces, punctuation, or numbers.
    private static void printWeirdly(String message){ // bad name
        StringBuilder edibleMessage = new StringBuilder(message);
        for (int a = 0; edibleMessage.length() > 0; a++){ //a represents the current line
            for (int b = 0; b <= a; b++) { // b represents position in line
                while (!edibleMessage.isEmpty() && b <= a){
                    int c = edibleMessage.toString().toLowerCase().charAt(0);
                    if (c >= 'a' && c <= 'z'){
                        System.out.print(edibleMessage.charAt(0));
                        b++;
                    }
                    edibleMessage.deleteCharAt(0);
                }
                if (edibleMessage.isEmpty() && b <= a){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
/* Lol I made notes and wanted to do math instead :/
        Essentially the number of characters  F(n) = n + F(n-1) where n is the number of lines.
        Or in recurrence, F(n) = n + (n-1) + (n-2) ... (n-k) where k = n.
        Neat little math trick, 1/2 ( (n + n-k) + (n-1 + n-k+1) + (n-2 + n-k+2)... (n-k + n-k+k) where eventually k = n)
        If F(n) = 1/2 n * (n+1) gets number of character given lines, then 2F(n) = n^2 + n, use quadratic formula
        x = (1 + rad(1 - 2y))/2(1/2)
*/