import java.util.ArrayList;
import java.util.List;

public class Map {
    private Location[][] grid;
    static int[][] locations = {
            //house coordinates
            {0, 3}, {3, 2}, {5, 0}, {11, 10}, {10, 10}, {9, 10}, {11, 12}, {10, 12},
            {9, 12}, {7, 6}, {5, 16}, {4, 19}, {16, 13}, {18, 19}, {18, 3}, {7, 5},
            {7, 4}, {7, 3}, {7, 2}, {19, 3}, {16, 3}, {15, 3}, {19, 4}, {19, 5},
            {18, 5}, {17, 5}, {15, 4}, {15, 5}, {16, 5}, {5, 15},

            //office
            {18, 1}, {10, 7}, {1, 1}, {19, 14}, {7, 18},

            //sea
            {9, 19}, {10, 19}, {10, 18}, {15, 18},{16, 18},{17, 18}, {11, 18}, {12, 18}, {13, 18},
            {14, 18}, {11, 17}, {12, 17}, {13, 17}, {11, 19}, {12, 19}, {13, 19}, {14, 19}, {15, 19},
            {16, 19}, {19, 18}, {17, 15}, {16, 15}, {17, 16}, {16, 16}, {19, 17}, {19, 16}, {14,17},
            {15, 16}, {15, 17}, {15, 18}, {14, 16},

            //points of interest
            {19, 12}, {19, 9}, {19, 10}, {19, 11},{18, 12}, {18, 9}, {18, 10}, {18, 11},{17, 12}, {17, 9},
            {17, 10}, {17, 11}, {10, 0}, {11, 0}, {12, 0}, {10, 1}, {11, 1}, {12, 1}, {0, 13}, {0, 14},
            {1, 13}, {1, 14},

            //road
            {4, 0}, {3, 1}, {2, 1}, {16, 0}, {16, 1}, {17, 1}, {17, 2}, {17, 3}, {2, 2}, {2, 3}, {1, 3},
            {6, 10}, {9, 6}, {9, 11}, {10, 11}, {11, 11}, {9, 7}, {18,14}, {18, 15}, {6, 8}, {7, 11},
            {18,16}, {18,17}, {6, 11}, {18,18}, {17,14}, {16,14}, {18, 4}, {17, 4}, {16, 4}, {18, 4},
            {8, 7}, {7, 7}, {6, 7}, {6, 6}, {6, 5}, {6, 4}, {6, 3}, {6, 2}, {6, 1}, {5, 1}, {4, 1}, {6, 9},
            {6, 10}, {6,11}, {8,11}, {14, 11}, {13, 11}, {12, 11}, {14, 10}, {15, 10}, {16, 10}, {13, 4},
            {14, 12}, {14, 13}, {14, 14}, {15, 14}, {14, 8}, {14, 9}, {14, 4}, {13, 7}, {13, 6}, {13, 5},
            {14, 7}, {18, 7}, {17, 7}, {16, 7}, {15, 7}, {18, 8}, {12, 5}, {11, 5}, {7, 1}, {8, 1}, {9, 1},
            {10, 5}, {9, 5}, {11, 2}, {11, 3}, {11, 4}, {13, 14}, {12, 14}, {11, 14}, {10, 14}, {9, 14},
            {8, 14}, {7, 14}, {6, 14}, {6, 15}, {6, 16}, {6, 17}, {6, 18}, {6, 19}, {4, 18}, {5, 18}, {5, 9},
            {4, 9}, {4, 10}, {4, 11}, {4, 12}, {0, 12}, {1, 12}, {2, 12}, {3, 12}, {0, 18}, {1, 18}, {2, 18},
            {3, 18}, {1, 17}, {1, 16}, {1, 15}

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

    public void getBuildings(User passenger) { //could be refactored


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
        for (int i = 66; i < 88; i++) {
            int poiX = locations[i][0];
            int poiY = locations[i][1];
            grid[poiX][poiY] = new Location(poiX, poiY);
            grid[poiX][poiY].setDisplayPOI();
        }
        for (int i = 88; i < 198; i++) {
            int roadX = locations[i][0];
            int roadY = locations[i][1];
            grid[roadX][roadY] = new Location(roadX, roadY);
            grid[roadX][roadY].setDisplayRoad();
        }
        if (passenger.getCurrentLocation() != null){
            grid[passenger.getCurrentLocation().getX()][passenger.getCurrentLocation().getY()] = passenger.getCurrentLocation();
            grid[passenger.getCurrentLocation().getX()][passenger.getCurrentLocation().getY()].setDisplayPassenger();
        }

        for (int i = 35; i < 66; i++) {
            int seaX = locations[i][0];
            int seaY = locations[i][1];
            grid[seaX][seaY] = new Location(seaX, seaY);
            grid[seaX][seaY].setDisplaySea();
        }
        if (passenger.getDestination() != null) {
            grid[passenger.getDestination().getX()][passenger.getDestination().getY()] = passenger.getDestination();
            grid[passenger.getDestination().getX()][passenger.getDestination().getY()].setDisplayPassengerDestination();
        }

    }

    public void Display(User passenger) {
        getBuildings(passenger);
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
        private char getSymbol(int i, int j) {//method to get symbol
        char symbol = Location.displayNoRoad; // Default to road symbol
        if (grid[i][j].getDisplayHouse() == 'H') {
            symbol = 'H';
        } else if (grid[i][j].getDisplayOffice() == 'O') {
            symbol = 'O';
        } else if (grid[i][j].getDisplaySea() == '/') {
            symbol = '/';
        }else if (grid[i][j].getDisplayPOI() == '$') {
            symbol = '$';
        }else if (grid[i][j].getDisplayRoad() == '*') {
            symbol = '*';
        }else if (grid[i][j].getDisplayPassengerDestination() == '@'){
            symbol = '@';
        }else if (grid[i][j].getDisplayPassenger() == '&'){
            symbol = '&';
        }
        return symbol;
    }
    public void getLegend(){
        System.out.println("Piltover: Legend\nHouses: H\nOffices: O\nBody of Water: /\nNon Road: ." +
                "\nPassenger: &\nTaxis: !\nPoints of Interest: $");
    }
}