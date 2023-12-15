import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class AStarAlgorithm extends Location {

   ListSingleton singleton = ListSingleton.getInstance();
   User passenger = singleton.getPassenger();


    int ROWS = 20;
    int COLS = 20;

    //roadMap with obstacles represented as null
    Location[][] roadMap = new Location[ROWS][COLS];
    //Location startLocation = new Location(passenger.getPickupPoint()); // Starting node
    //Location endLocation = new Location(passenger.getClosestDestination()); // Destination node
    Location startLocation = new Location(2, 3); // Starting node
    Location endLocation = new Location(6, 8);
    int movementCost = 1;

    public AStarAlgorithm(int x, int y) {
        super(x, y);
    }



    public List<Location> getNeighbours(Location location) {
        List<Location> neighbours = new ArrayList<>();
        // Logic to get neighbouring nodes based on the roadMap boundaries
        // Define possible moves (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = location.x + dx[i];
            int newY = location.y + dy[i];

            // Check if the new coordinates are within roadMap boundaries and adds to neighbours
            if (isValid(newX, newY)) {
                neighbours.add(roadMap[newX][newY]);
            }
        }
        return neighbours;
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS && roadMap[x][y] != null;
        //Coordinate: not = to 0, between the number of rows and columns and is not = to null(obstacle)
    }

    public int calculateHCost(Location location) {
        // Calculate heuristic (h) with Manhattan distance from current location to endLocation (estimation)
        return Math.abs(location.x - endLocation.x) + Math.abs(location.y - endLocation.y);

    }

    public List<Location> findPath() {
        List<Location> uncheckedSet = new ArrayList<>();
        Set<Location> checkedSet = new HashSet<>();

        uncheckedSet.add(startLocation);
        System.out.println(startLocation+ "added to unchecked");
        while (!uncheckedSet.isEmpty()) { //keeps going til the unchecked list is empty (everything is checked)
            System.out.println(uncheckedSet + "is not empty");
            Location currentLocation = uncheckedSet.get(0);
            //to find lowest total cost (f and h but f is considered first)
            for (int i = 1; i < uncheckedSet.size(); i++) {
                if (uncheckedSet.get(i).getFCost() < currentLocation.getFCost() ||
                        (uncheckedSet.get(i).getFCost() == currentLocation.getFCost() &&
                                uncheckedSet.get(i).hCost < currentLocation.hCost)) {
                    currentLocation = uncheckedSet.get(i); //stores element with the lowest cost
                    System.out.println(currentLocation + "has the lowest cost");
                }
            }

            //removed because it is checked
            uncheckedSet.remove(currentLocation);
            checkedSet.add(currentLocation);
            System.out.println(currentLocation +"is checked");
            //if destination is reached
            if (currentLocation.equals(endLocation)) {
                return reconstructPath(currentLocation);
            }

            List<Location> neighbours = getNeighbours(currentLocation);
            for (Location neighbour : neighbours) {
                if (neighbour == null || checkedSet.contains(neighbour)) {
                    continue; // skips the rest of the code if there's an invalid neighbour
                }

                int newCost = currentLocation.gCost + movementCost; // cost from currentLocation to neighbour //
                if (newCost < neighbour.gCost || !uncheckedSet.contains(neighbour)) {
                    neighbour.gCost = newCost;
                    neighbour.hCost = calculateHCost(neighbour);
                    neighbour.parent = currentLocation;

                    if (!uncheckedSet.contains(neighbour)) {
                        uncheckedSet.add(neighbour);
                    }
                }
            }
        }
        return null;
    }

    List<Location> reconstructPath(Location current) {
        List<Location> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public void roadMapCoordinates(Map map) {
        map.storeMapLocations();
        for (int i = 88; i < 198; i++) {
            Location location = map.mapLocations.get(i);
            int roadX = location.getX();
            int roadY = location.getY();
            roadMap[roadX][roadY] = location; //this sets road
        }
    }

    public void printEntireGrid(){
        for (int i = 0; i < roadMap.length - 1; i++){
            System.out.println();
            for (int j = 0; j < roadMap.length - 1; j++) {
                System.out.print(roadMap[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        AStarAlgorithm aStar = new AStarAlgorithm(20, 20);
        //printEntireGrid();

        List<Location> path = aStar.findPath();
        TaxiDriver.setTravelTime(0);
        //ensures there is an actual path
        if (path != null) {
            for (Location location : path) {
                System.out.println("(" + location.x + ", " + location.y + ")");
                //TaxiDriver.setTravelTime(TaxiDriver.getTravelTime()++);
            }
        } else {
            System.out.println("Your location cannot be accessed by taxi.");
        }
    }
}


/*for (int i = 0; i < roadMap.length - 1; i++){
        System.out.print(roadMap[i][0]);
        System.out.print(roadMap[i][1]);
        }

 */