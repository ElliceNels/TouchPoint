import java.util.Random;
public class Map {
<<<<<<< HEAD
    private static Location[][] grid;
=======
    private int[][] grid;



    public void getPath(){//starting point is user x,y. Finished is inputted x,y
>>>>>>> 09ae3225fa82bbd91fcd12e8f290505cbfb95e05

    public Map(int rows, int cols) {
        grid = new Location[rows][cols];
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    public static void Display() {//Method to display map
        Location[][] grid = new Location[10][10];//length and width of map
        for(int n = 0;n < (grid.length);n++){
            int min = 1;
            int max = grid.length-1;//set min and max of random number
            Random rand = new Random();
            int h = rand.nextInt((max - min) + 1) + min;//this generates house at random number
            int H = rand.nextInt((max - min) + 1) + min;
            grid[h][H] = new Location(h,h);
            grid[h][H].setDisplayBuildings('H');//this sets house
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
