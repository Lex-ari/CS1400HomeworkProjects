package Homework2;

//Code by Alex Mariano
// CS1300
// David Johannsen

public class PowersChart {
    private static int[][] powerArray = new int[10][10];//row, col
    private static int[] spacing = new int[10];


    public static void main(String[] args){

    }

    private static int[][] makePowerArray(){
        for (int y = 1; y <= 10; y++){
            for (int x = 1; x <= 10; x++){
                powerArray[y][x] = (int)Math.pow(y, x);
            }
        }
        return powerArray;
    }

    private static void calculateSpacing(){
        for (int x = 0; x < 10; x++){

        }
    }
}
