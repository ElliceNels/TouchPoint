import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class AStarAlgorithm extends Location {
   static ListSingleton singleton = ListSingleton.getInstance();
   static User passenger = singleton.getPassenger();

    static int ROWS = 20;
    static int COLS = 20;

    //roadMap with obstacles represented as null
    static Location[][] roadMap = new Location[ROWS][COLS];
    static Location startLocation = new Location(passenger.getPickupPoint()); // Starting node
    static Location endLocation = new Location(passenger.getDestination()); // Destination node
    static int movementCost = 1;

    public AStarAlgorithm(int x, int y) {
        super(x, y);
    }

    public static List<Location> getNeighbours(Location location) {
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

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS && roadMap[x][y] != null;
        //Coordinate: not = to 0, between the number of rows and columns and is not = to null(obstacle)
    }

    public static int calculateHCost(Location location) {
        // Calculate heuristic (h) with Manhattan distance from current location to endLocation (estimation)
        return Math.abs(location.x - endLocation.x) + Math.abs(location.y - endLocation.y);

    }

    public static List<Location> findPath(Map map) {
        //roadMapCoordinates(map);
        List<Location> uncheckedSet = new ArrayList<>();
        Set<Location> checkedSet = new HashSet<>();

        uncheckedSet.add(startLocation);

        //keeps going til the unchecked list is empty (everything is checked)
        while (!uncheckedSet.isEmpty()) {
            Location currentLocation = uncheckedSet.get(0);
            //to find the lowest total cost (f and h but f is considered first)
            for (int i = 1; i < uncheckedSet.size(); i++) {
                if (uncheckedSet.get(i).getFCost() < currentLocation.getFCost() ||
                        (uncheckedSet.get(i).getFCost() == currentLocation.getFCost() &&
                                uncheckedSet.get(i).hCost < currentLocation.hCost)) {
                    currentLocation = uncheckedSet.get(i); //stores element with the lowest cost
                }
            }

            //removed because it is checked
            uncheckedSet.remove(currentLocation);
            checkedSet.add(currentLocation);

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

    static List<Location> reconstructPath(Location current) {
        List<Location> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void roadMapCoordinates(Map map) {
        for (int i = 88; i < 198; i++) {
            Location location = map.mapLocations.get(i);
            int roadX = location.getX();
            int roadY = location.getY();
            roadMap[roadX][roadY] =  location; //this sets road
        }
    }

    public static void printEntireGrid(){
        for (int i = 0; i < roadMap.length - 1; i++){
            System.out.println();
            for(int j = 0; j < roadMap.length -1; j++) {
                System.out.print(roadMap[i][j]);
            }
        }
    }
}
