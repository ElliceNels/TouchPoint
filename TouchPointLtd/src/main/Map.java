import java.util.ArrayList;
import java.util.List;

public class Map {
    private Location[][] grid;
    static int[][] locations = {
            {0, 3}, {3, 2}, {5, 0}, {11, 10}, {10, 10}, {9, 10}, {11, 12}, {10, 12},
            {9, 12}, {7, 6}, {5, 16}, {4, 19}, {16, 13}, {18, 19}, {18, 3}, {7, 5},
            {7, 4}, {7, 3}, {7, 2}, {19, 3}, {16, 3}, {15, 3}, {19, 4}, {19, 5},
            {18, 5}, {17, 5}, {15, 4}, {15, 5}, {16, 5}, {5, 15},//house coordinates

            {18, 1}, {10, 7}, {1, 1}, {19, 14}, {7, 18},//office

            {9, 19}, {10, 19}, {10, 18}, {15, 18},{16, 18},{17, 18}, {11, 18}, {12, 18}, {13, 18},
            {14, 18}, {11, 17}, {12, 17}, {13, 17}, {11, 19}, {12, 19}, {13, 19}, {14, 19}, {15, 19},
            {16, 19}, {19, 18}, {17, 15}, {16, 15}, {17, 16}, {16, 16}, {19, 17}, {19, 16}, {14,17},
            {15, 16}, {15, 17}, {15, 18},//sea

            {0, 1}, {0, 2}, {4, 0}, {3, 0}, {3, 1}, {2, 1}, {16, 0}, {16, 1}, {17, 1}, {17, 2}, {17, 3},
            {9, 6}, {9, 11}, {10, 11}, {11, 11}, {9, 7}, {18,14}, {18, 15}, {6, 8}, {7, 11}, {18,16}, {18,17},
            {18,18}, {17,14}, {16,14}, {18, 4}, {17, 4}, {16, 4}, {18, 4}, {8, 7}, {7, 7}, {6, 7}, {6, 6}, {6, 5},
            {6, 4}, {6, 3}, {6, 2}, {6, 1}, {5, 1}, {4, 1}, {6, 9}, {6, 10}, {6,11}, {8,11}//road

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
        for (int i = 0; i < 30; i++) {
            int houseX = locations[i][0];
            int houseY = locations[i][1];
            grid[houseX][houseY] = new Location(houseX, houseY);
            grid[houseX][houseY].setDisplayHouse();//this sets house
        }
        for (int i = 30; i < 35; i++) {
            int officeX = locations[i][0];
            int officeY = locations[i][1];
            grid[officeX][officeY] = new Location(officeX, officeY);
            grid[officeX][officeY].setDisplayOffice();
        }
        for (int i = 35; i < 65; i++) {
            int seaX = locations[i][0];
            int seaY = locations[i][1];
            grid[seaX][seaY] = new Location(seaX, seaY);
            grid[seaX][seaY].setDisplaySea();
        }

        for (int i = 65; i < 109; i++) {
            int roadX = locations[i][0];
            int roadY = locations[i][1];
            grid[roadX][roadY] = new Location(roadX, roadY);
            grid[roadX][roadY].setDisplayRoad();
        }

    }

    public void Display() {
        getBuildings();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    char symbol = getSymbol(i, j);
                    System.out.print("  " + symbol + "  ");
                    } else {
                        System.out.print("  " + Location.displayNoRoad + "  "); // Star which represents road
                    }
                }
                System.out.println();
            }getLegend();
        }
        private char getSymbol(int i, int j) {
        char symbol = Location.displayNoRoad; // Default to road symbol
        if (grid[i][j].getDisplayHouse() == 'H') {
            symbol = 'H';
        } else if (grid[i][j].getDisplayOffice() == 'O') {
            symbol = 'O';
        } else if (grid[i][j].getDisplaySea() == '~') {
            symbol = '~';
        }
        else if (grid[i][j].getDisplayRoad() == '*') {
            symbol = '*';
        }
        return symbol;
    }
    public void getLegend(){
        System.out.println("Piltover: Legend\nHouses: H\nOffices: O\nBody of Water: ~\nNon Road: :\nPassenger: &\nTaxis: !");
    }
}