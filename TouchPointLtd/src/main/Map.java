import java.util.ArrayList;
import java.util.List;

public class Map {
    private Location[][] grid;
    static int[][] houselocations = {
            {0, 3},
            {3, 2},
            {5, 0},
            {11, 10},
            {10, 10},
            {9, 10},
            {11, 12},
            {10, 12},
            {9, 12},
            {7, 6},
            {5, 16},
            {4, 19},
            {16, 13},
            {18, 19},
            {18, 3},

            {18,1},
            {10,7},
            {1,1},
            {19,14},
            {7,18},

    };

    public Map(int rows, int cols) {
        grid = new Location[rows][cols];
    }

    public Location[][] getGrid() {
        return grid;
    }

    public void setGrid(Location[][] grid) {
        this.grid = grid;
    }
    public void getBuildings() {
        for (int i = 0; i < 15; i++) {
            int houseX = houselocations[i][0];
            int houseY = houselocations[i][1];
            grid[houseX][houseY] = new Location(houseX, houseY);
            grid[houseX][houseY].setDisplayHouse();//this sets house
        }
        for(int i = 15;i < 20;i++){
            int officeX = houselocations[i][0];
            int officeY = houselocations[i][1];
            grid[officeX][officeY] = new Location(officeX,officeY);
            grid[officeX][officeY].setDisplayOffice();
        }
    }
    public void Display() {
        getBuildings();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    char symbol = Location.displayRoad; // Default to road symbol
                    if (grid[i][j].getDisplayHouse() == 'H') {
                        symbol = 'H';
                    } else if (grid[i][j].getDisplayOffice() == 'O') {
                        symbol = 'O';
                    }
                    System.out.print("  " + symbol + "  ");
                } else {
                    System.out.print("  " + Location.displayRoad + "  "); // Star which represents road
                }
            }
            System.out.println();
        }
    }

}
