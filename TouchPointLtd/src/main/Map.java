import java.util.Random;
public class Map {

    private static Location[][] grid;


    public Map(int rows, int cols) {
        grid = new Location[rows][cols];
    }

    public Location[][] getGrid() {
        return grid;
    }

    public void setGrid(Location[][] grid) {
        Map.grid = grid;
    }
    public static void Display() {//Method to display map
        new Map(10,10); //length and width of map
        for(int n = 0; n < (grid.length); n++){
            int min = 1;
            int max = grid.length - 1;//set min and max of random number
            Random rand = new Random();
            int houseX = rand.nextInt((max - min) + 1) + min;//this generates house at random number
            int houseY = rand.nextInt((max - min) + 1) + min;
            grid[houseX][houseY] = new Location(houseX, houseX);
            grid[houseX][houseY].setDisplayBuildings('H');//this sets house
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != null) {
                    System.out.print(" " + grid[i][j].getDisplayBuildings() + " ");
                    //this prints house if there is no star in place
                }
               else{ System.out.print(" * ");//star which represents road
               }
            }
            System.out.println();
        }
    }
}
