package Homework2;

//Code by Alex Mariano
// CS1300
// David Johannsen

import java.util.Arrays;

public class PowersChart {
    private static int[][] powerArray = new int[10][4];//row, col
    private static int[] spacing = new int[powerArray[0].length];


    public static void main(String[] args){
        makePowerArray();
        calculateSpacing();
        /*for (int y = 0; y < powerArray.length; y++){
            System.out.println(Arrays.toString(powerArray[y]));
        }*/
        //System.out.println(Arrays.toString(spacing));
        printArrays();
    }

    //prints arrays, as name implies
    private static void printArrays(){
        for (int x = 0; x < powerArray[powerArray.length - 1].length; x++){
            String formatter = "%" + spacing[x] + "d ";
            System.out.printf(formatter, x + 1);
        }
        System.out.println();
        System.out.println();
        String printString = "";
        for (int y = 0; y < powerArray.length; y++){
            for (int x = 0; x < powerArray[powerArray.length - 1].length; x++){
                String formatter = "%" + spacing[x] + "d ";
                System.out.printf(formatter, powerArray[y][x]);
            }
            System.out.println();
        }
        //System.out.println(Arrays.toString(spacing));
    }

    //turns powerArray[][] into powers.
    private static void makePowerArray(){
        for (int y = 0; y < powerArray.length; y++){
            for (int x = 0; x < powerArray[0].length; x++){
                powerArray[y][x] = (int)Math.pow(y + 1, x + 1);
            }
        }
    }

    //As name implies, calculates number of digits needed for the entire col
    private static void calculateSpacing(){
        for (int x = 0; x < powerArray[0].length; x++){
            int testNumber = powerArray[powerArray.length - 1][x];
            int digits = 1;
            while (testNumber / 10 > 0){
                testNumber = testNumber / 10;
                digits++;
            }
            spacing[x] = digits;
        }
    }
}
