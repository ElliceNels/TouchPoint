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

    public static final String CAR_EMOJI = "\uD83D\uDE95";
    ListSingleton singleton = ListSingleton.getInstance();  //allows access to allTaxis list

    //Take all values from csv
    public List<Location> storeMapLocations() {
        boolean[]presentloc = {false, false, false, false, false, false, false, false};
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
                mapLocations.add(new Location(x, y, presentloc));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      return mapLocations;
    }
    public void addLocationsToMap(User passenger){
        storeMapLocations();
        for(int i = 0;i < 30;i++){
            Location location = new Location(mapLocations.get(i));
            int houseX = location.getX();
            int houseY = location.getY();
            grid[houseX][houseY] = location;
            location.setHousePresent(true);
            //location.choosePlace(location);
        }
        for(int i = 30;i < 35;i++){
            Location location = new Location(mapLocations.get(i));
            int officeX = location.getX();
            int officeY = location.getY();
            grid[officeX][officeY] = location;
            location.setOfficePresent(true);
            //location.choosePlace(location);

        }
        for (int i = 66; i < 88; i++) {
            Location location = new Location(mapLocations.get(i));
            int poiX = location.getX();
            int poiY = location.getY();
            grid[poiX][poiY] = location;
            location.setPOIPresent(true);
            //location.choosePlace(location);

        }
        for (int i = 88; i < 198; i++) {
            Location location = new Location(mapLocations.get(i));
            int roadX = location.getX();
            int roadY = location.getY();
            grid[roadX][roadY] = location;
            location.setRoadPresent(true);
            //location.choosePlace(location);

        }
        if (passenger.getCurrentLocation() != null){
            grid[passenger.getCurrentLocation().getX()][passenger.getCurrentLocation().getY()] = passenger.getCurrentLocation();
            //grid[passenger.getCurrentLocation().getX()][passenger.getCurrentLocation().getY()].setDisplayPassenger();
        }
        for (int i = 35; i < 66; i++) {
            Location location = new Location(mapLocations.get(i));
            int seaX = location.getX();
            int seaY = location.getY();
            grid[seaX][seaY] = location;
            location.setSeaPresent(true);
            //choosePlace(location);

        }
        if (passenger.getDestination() != null) {
            grid[passenger.getDestination().getX()][passenger.getDestination().getY()] = passenger.getDestination();
            //grid[passenger.getDestination().getX()][passenger.getDestination().getY()].setDisplayPassengerDestination();
        }
        choosePlace();
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
        Random rand = new Random();
        for(int i = 0;i < singleton.getList().size();i++){
            int startIndex = 88;
            int endIndex = 197;
            int randInt = rand.nextInt((endIndex - startIndex + 1)) + startIndex;
            Location taxiLocation = mapLocations.get(randInt);
            grid[taxiLocation.getX()][taxiLocation.getY()] = taxiLocation;
            singleton.setTaxiLocation(taxiLocation);
            //grid[taxiLocation.getX()][taxiLocation.getY()].setDisplayTaxi();
        }
    }


    public void choosePlace() { //i is array element with location
        //for (int j = 0; j < Map.grid[][].array().length; j++) {       //j is the index of the type of this is looking for
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]== null){
                    System.out.print(ANSI_BLACK + " "+Location.getDisplayNoRoad()+" " + ANSI_RESET);
                } else if (grid[i][j].array()[1]) {
                    System.out.print(ANSI_BLACK +" "+ Location.getDisplayPassengerDestination()+" " + ANSI_RESET);
                } else if (grid[i][j].array()[2]) {
                    System.out.print(ANSI_RED + " "+Location.getDisplayTaxi() +" "+ ANSI_RESET);
                } else if (grid[i][j].array()[3]) {
                    System.out.print(ANSI_WHITE + " "+ Location.getDisplayRoad()+" " + ANSI_RESET);
                } else if (grid[i][j].array()[4]) {
                    System.out.print(ANSI_BLUE + " "+Location.getDisplaySea()+ " "+ANSI_RESET);
                } else if (grid[i][j].array()[5]) {
                    System.out.print(ANSI_LIGHT_BROWN + " "+Location.getDisplayOffice()+" "+ ANSI_RESET);
                } else if (grid[i][j].array()[6]) {
                    System.out.print(" "+Location.getDisplayHouse()+" ");
                } else if (grid[i][j].array()[7]) {
                    System.out.print(ANSI_YELLOW + " "+Location.getDisplayPOI()+" "+ ANSI_RESET);
                } else if (grid[i][j].array()[8]) {
                    System.out.print(ANSI_BLACK +" "+ Location.getDisplayNoRoad()+" "+ ANSI_RESET);
                }else if (grid[i][j].array()[0]) {
                    System.out.print(ANSI_PURPLE +" "+ Location.getDisplayPassenger()+" "+ ANSI_RESET);
                }
            }
        } System.out.println();

    }
    public void Display(User passenger) {
        getLegend();
        addLocationsToMap(passenger);
        getTaxiDrivers();
    }
    public void getLegend(){
        System.out.println("Piltover Legend\nHouses: H      " + ANSI_YELLOW + "Offices: O      " + ANSI_BLUE + "Body of Water: /        " + ANSI_BLACK + "Non Road: .     " + ANSI_PURPLE + "Passenger: &        Passenger Destination: @       " + ANSI_RED + "Taxis: !        " + ANSI_YELLOW + "Points of Interest: $        " + ANSI_WHITE + "Roads: *" + ANSI_RESET);
    }
}