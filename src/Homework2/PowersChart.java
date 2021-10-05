package Homework2;

//Code by Alex Mariano
// CS1300
// David Johannsen

import java.util.Arrays;

public class PowersChart {
    private static int[][] powerArray = new int[10][10];//row, col
    private static int[] spacing = new int[10];


    public static void main(String[] args){
        makePowerArray();
        calculateSpacing();
        for (int y = 0; y < 10; y++){
            System.out.println(Arrays.toString(powerArray[y]));
        }
        System.out.println(Arrays.toString(spacing));
    }

    private static void makePowerArray(){
        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++){
                powerArray[y][x] = (int)Math.pow(y + 1, x + 1);
            }
        }
    }

    private static void calculateSpacing(){
        for (int x = 0; x < 10; x++){
            int testNumber = powerArray[9][x];
            int digits = 1;
            while (testNumber / 10 > 0){
                testNumber = testNumber / 10;
                digits++;
            }
            spacing[x] = digits;
        }

    }
}
