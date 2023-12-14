import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Map {
    static private Location[][] grid;
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
    public static final String ANSI_LIGHT_BROWN = "\u001B[38;2;205;190;145m";

    static final private char displayOffice = 'O';//set as empty to read building type
    static final private char displayHouse = 'H';//displays houses as H
    static final private char displayRoad = '*';//displays roads as *
    static final private char displaySea = '/';//displays seas as ~
    static final private char displayPOI = '$';//displays point of interest as $
    static final private char displayNoRoad = '.';//road is not empty as it is always inputted last
    static final char displayPassenger = '&';
    static final private char displayPassengerDestination = '@';
    static final private char displayTaxi = '!';

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
    public void addToMap(User passenger){
        storeMapLocations();
        addToGrid(0, 30);
        addToGrid(30, 35);
        addToGrid(66, 88);
        addToGrid(88, 198);
        addToGrid(35, 66);
        if (passenger.getCurrentLocation() != null){
            grid[passenger.getCurrentLocation().getX()][passenger.getCurrentLocation().getY()] = passenger.getCurrentLocation();
        }
        if (passenger.getDestination() != null) {
            grid[passenger.getDestination().getX()][passenger.getDestination().getY()] = passenger.getDestination();
        }
        choosePlace();
    }
    private void addToGrid(int start, int end) {
        for (int i = start; i < end; i++) {
            Location location = new Location(mapLocations.get(i));
            int x = location.getX();
            int y = location.getY();
            grid[x][y] = location;

            if (start == 0) {
                location.setHousePresent(true);
            } else if (start == 30) {
                location.setOfficePresent(true);
            } else if (start == 66) {
                location.setPOIPresent(true);
            } else if (start == 88) {
                location.setRoadPresent(true);
            }else if (start == 35){
                location.setSeaPresent(true);
            }
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
        storeMapLocations();
        singleton.storeTaxiDetails(singleton.getList());
        List<TaxiDriver> allTaxis = singleton.getList();
        Random rand = new Random();
        for(int i = 0;i < singleton.getList().size();i++){
            int startIndex = 88;
            int endIndex = 197;
            int randInt = rand.nextInt((endIndex - startIndex + 1)) + startIndex;
            Location taxiLocation = mapLocations.get(randInt);
            singleton.setTaxiLocation(taxiLocation);
            grid[taxiLocation.getX()][taxiLocation.getY()] = taxiLocation;
            taxiLocation.setTaxiPresent(true);
            taxiLocation.getObjectList().add(allTaxis.get(i));
        }
    }


    public void choosePlace() { //i is an array element with location
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]== null){
                    System.out.print(ANSI_BLACK + " "+displayNoRoad+" " + ANSI_RESET);
                } else if (grid[i][j].array()[1]) {
                    System.out.print(ANSI_BLACK +" "+ displayPassengerDestination+" " + ANSI_RESET);
                } else if (grid[i][j].array()[2]) {
                    System.out.print(ANSI_RED + " "+displayTaxi +" "+ ANSI_RESET);
                } else if (grid[i][j].array()[3]) {
                    System.out.print(ANSI_WHITE + " "+ displayRoad+" " + ANSI_RESET);
                } else if (grid[i][j].array()[4]) {
                    System.out.print(ANSI_BLUE + " "+displaySea+ " "+ANSI_RESET);
                } else if (grid[i][j].array()[5]) {
                    System.out.print(ANSI_LIGHT_BROWN + " "+displayOffice+" "+ ANSI_RESET);
                } else if (grid[i][j].array()[6]) {
                    System.out.print(" "+displayHouse+" ");
                } else if (grid[i][j].array()[7]) {
                    System.out.print(ANSI_YELLOW + " "+displayPOI+" "+ ANSI_RESET);
                } else if (grid[i][j].array()[8]) {
                    System.out.print(ANSI_BLACK +" "+ displayNoRoad+" "+ ANSI_RESET);
                }else if (grid[i][j].array()[0]) {
                    System.out.print(ANSI_PURPLE +" "+ displayPassenger+" "+ ANSI_RESET);
                }
            }
        } System.out.println();

    }
    public void Display(User passenger) {
        getLegend();
        addToMap(passenger);
        getTaxiDrivers();
    }
    public void getLegend(){
        System.out.println("Piltover Legend\nHouses: H      " + ANSI_LIGHT_BROWN + "Offices: O      " + ANSI_BLUE + "Body of Water: /        " + ANSI_BLACK + "Non Road: .     " + ANSI_PURPLE + "Passenger: &        Passenger Destination: @       " + ANSI_RED + "Taxis: !        " + ANSI_YELLOW + "Points of Interest: $        " + ANSI_WHITE + "Roads: *" + ANSI_RESET);
    }
}