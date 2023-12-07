import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Map {

    private Location[][] grid;
    List<Location> mapLocations = new ArrayList<>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String CAR_EMOJI = "\uD83D\uDE95";
    ListSingleton singleton = ListSingleton.getInstance();  //allows access to allTaxis list

    //Take all values from csv
    public List<Location> storeMapLocations() {
        String coordinates = "src//main//MapLocations.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(coordinates))) {
            String line;
            br.readLine();
            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                // Split the line into fields using a comma as the delimiter
                String[] fields = line.split(",");
                int x = Integer.parseInt(fields[0]);
                int y = Integer.parseInt(fields[1]);
                mapLocations.add(new Location(x, y));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      return mapLocations;
    }
    public void addLocationsToMap(User passenger){
        storeMapLocations();
        for(int i = 0;i < 30;i++){
            Location location = mapLocations.get(i);
            int houseX = location.getX();
            int houseY = location.getY();
            grid[houseX][houseY] = new Location(houseX, houseY);
            grid[houseX][houseY].setDisplayHouse();//this sets house
        } for(int i = 30;i < 35;i++){
            Location location = mapLocations.get(i);
            int officeX = location.getX();
            int officeY = location.getY();
            grid[officeX][officeY] = new Location(officeX, officeY);
            grid[officeX][officeY].setDisplayOffice();//this sets office
        }for (int i = 66; i < 88; i++) {
            Location location = mapLocations.get(i);
            int poiX = location.getX();
            int poiY = location.getY();
            grid[poiX][poiY] = new Location(poiX, poiY);
            grid[poiX][poiY].setDisplaySea();//this sets poi
        }for (int i = 88; i < 198; i++) {
            Location location = mapLocations.get(i);
            int roadX = location.getX();
            int roadY = location.getY();
            grid[roadX][roadY] = new Location(roadX, roadY);
            grid[roadX][roadY].setDisplayRoad();//this sets road
        }if (passenger.getCurrentLocation() != null){
            grid[passenger.getCurrentLocation().getX()][passenger.getCurrentLocation().getY()] = passenger.getCurrentLocation();
            grid[passenger.getCurrentLocation().getX()][passenger.getCurrentLocation().getY()].setDisplayPassenger();
        }for (int i = 35; i < 66; i++) {
            Location location = mapLocations.get(i);
            int seaX = location.getX();
            int seaY = location.getY();
            grid[seaX][seaY] = new Location(seaX, seaY);
            grid[seaX][seaY].setDisplaySea();//this sets sea
        } if (passenger.getDestination() != null) {
            grid[passenger.getDestination().getX()][passenger.getDestination().getY()] = passenger.getDestination();
            grid[passenger.getDestination().getX()][passenger.getDestination().getY()].setDisplayPassengerDestination();
        }
    }
    public Map(int rows, int cols) {
        grid = new Location[rows][cols];
    }
    public Location[][] getGrid() {
        return grid;
    }
    public void setGrid(Location[][] grid) {
        this.grid = grid;
    }
    public void getTaxiDrivers(){
        singleton.storeTaxiDetails(singleton.getList());
        Random rand = new Random();
        for(int i = 0;i < singleton.getList().size();i++){
            int startIndex = 88;
            int endIndex = 197;
            int randInt = rand.nextInt((endIndex - startIndex + 1)) + startIndex;
            Location location = mapLocations.get(randInt);
            int TaxiX = location.getX();
            int TaxiY = location.getY();
            grid[TaxiX][TaxiY] = new Location(TaxiX, TaxiY);
            singleton.setTaxiLocation(grid[TaxiX][TaxiY]);
            grid[TaxiX][TaxiY].setDisplayTaxi();
            System.out.println(singleton.getTaxiLocation());
        }
    }

    public void Display(User passenger) {
        addLocationsToMap(passenger);
        getTaxiDrivers();
        getLegend();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    String symbol = getSymbol(i, j);
                    System.out.print(symbol);
                } else {
                    System.out.print(ANSI_BLACK + "  .  " + ANSI_RESET); // Dot which represents no road
                }
            }
            System.out.println();
        }
    }
    private String getSymbol(int i, int j) {//method to get symbol
        String symbol = "."; // Default to road symbol
        if (grid[i][j].getDisplayHouse() == 'H') {
            symbol = "  H  ";
        } else if (grid[i][j].getDisplayOffice() == 'O') {
            symbol = ANSI_YELLOW + "  O  " + ANSI_RESET;
        } else if (grid[i][j].getDisplaySea() == '/') {
            symbol = ANSI_BLUE + "  /  " + ANSI_RESET;
        }else if (grid[i][j].getDisplayPOI() == '$') {
            symbol =  ANSI_YELLOW + "  $  " +  ANSI_RESET;
        }else if (grid[i][j].getDisplayRoad() == '*') {
            symbol = ANSI_WHITE + "  *  " + ANSI_RESET;
        }else if (grid[i][j].getDisplayTaxi() == '!'){
            //symbol = "  " + CAR_EMOJI + " ";
            symbol = ANSI_RED + "  !  " + ANSI_RESET;
        }else if (grid[i][j].getDisplayPassengerDestination() == '@'){
            symbol = ANSI_PURPLE + "  @  " + ANSI_RESET;
        } else if (grid[i][j].getDisplayPassenger() == '&'){
            symbol = ANSI_PURPLE  + "  &  " + ANSI_RESET;
        }
        return symbol;
    }
    public void getLegend(){
        System.out.println("Piltover Legend\nHouses: H      " + ANSI_YELLOW + "Offices: O      " + ANSI_BLUE + "Body of Water: /        " + ANSI_BLACK + "Non Road: .     " + ANSI_PURPLE + "Passenger: &        Passenger Destination: @       " + ANSI_RED + "Taxis: !        " + ANSI_YELLOW + "Points of Interest: $        " + ANSI_WHITE + "Roads: *\n" + ANSI_RESET);
    }
}