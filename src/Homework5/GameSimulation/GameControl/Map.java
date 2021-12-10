package Homework5.GameSimulation.GameControl;
import Homework5.GameSimulation.TerrainTypes.*;

public class Map {
    private static Terrain[][] map = new Terrain[10][50];//row, col bc alex is bruh

    // Map is static, bc only one map may exist.

    public static Terrain getTerrainAtCoordinates(int y, int x){ // y and x start at 0 and end with n-1
        return map[y][x];
    }

    public static void initializeMap(){ // fills in random terrain
        for (int y = 0; y < map.length; y++){
            for (int x = 0; x < map[y].length; x++){
                map[y][x] = getRandomTerrain();
            }
        }
    }

    private static Terrain getRandomTerrain(){
        int randomTerrainNumber = (int)(Math.random() * 4);
        Terrain returnTerrain;
        switch (randomTerrainNumber){
            case 0 -> returnTerrain = new Forest();
            case 1 -> returnTerrain = new Grass();
            case 2 -> returnTerrain = new River();
            case 3 -> returnTerrain = new Sand();
            default -> returnTerrain = new Terrain();
        }
        return returnTerrain;
    }

    public int getMapLength(){
        return map[0].length;
    }

    public int getStartingPosition(){
        return map.length / 2;
    }

    public int getMapHeight(){
        return map.length;
    }

}
