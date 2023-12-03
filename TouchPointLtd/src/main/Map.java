public class Map {

    private static Location[][] grid;
    static int[][] houselocations = {
            {0, 3}, {3, 2}, {5, 0}, {11, 10},
            {10, 10}, {9, 10}, {11, 12}, {10, 12},
            {9, 12}, {7, 6}, {5, 16}, {4, 19}, {16, 13},
            {18, 19}, {18, 3},
    };
    static int[][]  officelocations = {
            {18,12},
            {10,7},
            {12,19},
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
        Map.grid = grid;
    }
    public static void getHouses() {
        for (int i = 0; i < houselocations.length; i++) {
            int houseX = houselocations[i][0];
            int houseY = houselocations[i][1];
            grid[houseX][houseY] = new Location(houseX, houseY);
            grid[houseX][houseY].setDisplayHouse();//this sets house
        }
    }
    public static void getOffices(){
        for(int i = 0;i < officelocations.length;i++){
            int officeX = officelocations[i][0];
            int officeY = officelocations[i][1];
            grid[officeX][officeY] = new Location(officeX,officeY);
            grid[officeX][officeY].setDisplayOffice();
        }
    }
    public static void Display() {//Method to display map
        new Map(20,20); //length and width of map
        getHouses();
        getOffices();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    char houseSymbol = grid[i][j].getDisplayHouse();
                    char officeSymbol = grid[i][j].getDisplayOffice();
                    if (houseSymbol == 'H') {
                        System.out.print("  " + houseSymbol + "  ");
                    }else if (officeSymbol == 'O') {
                        System.out.print("  " + officeSymbol + "  ");
                    } else if (grid[i][j] == null){
                        System.out.print("  " + Location.displayRoad + "  ");
                    }
                } else {
                    System.out.print("  " + Location.displayRoad + "  ");//star which represents road
                }
            }
            System.out.println();
        }
    }
}
