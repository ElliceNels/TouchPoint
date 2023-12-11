import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class AStarAlgorithm extends Location{
    static int ROWS = 5;
    static int COLS = 5;

    //grid with obstacles represented as null
    static Location[][] grid = new Location[ROWS][COLS];

    static Location startLocation = new Location(0, 0); // Starting node
    static Location endLocation = new Location(4, 4); // Destination node
    static int movementCost = 1;

    public AStarAlgorithm(int x, int y) {
        super(x, y);
    }

    static List<Location> getNeighbours(Location location) {
        List<Location> neighbours = new ArrayList<>();
        // Logic to get neighbouring nodes based on the grid boundaries
        // Define possible moves (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = location.x + dx[i];
            int newY = location.y + dy[i];

            // Check if the new coordinates are within grid boundaries and adds to neighbours
            if (isValid(newX, newY)) {
                neighbours.add(grid[newX][newY]);
            }
        }
        return neighbours;
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS && grid[x][y] != null;
        //Coordinate: not = to 0, between the number of rows and columns and is not = to null(obstacle)
    }

    static int calculateHCost(Location location) {
        // Calculate heuristic (h) with Manhattan distance from current location to endLocation (estimation)
        return Math.abs(location.x - endLocation.x) + Math.abs(location.y - endLocation.y);

    }

    static List<Location> findPath() {
        List<Location> uncheckedSet = new ArrayList<>();
        Set<Location> checkedSet = new HashSet<>();

        uncheckedSet.add(startLocation);

        while (!uncheckedSet.isEmpty()) { //keeps going til the unchecked list is empty (everything is checked)
            Location currentLocation = uncheckedSet.get(0);
            //to find lowest total cost (f and h but f is considered first)
            for (int i = 1; i < uncheckedSet.size(); i++) {
                if (uncheckedSet.get(i).getFCost() < currentLocation.getFCost() ||
                        (uncheckedSet.get(i).getFCost() == currentLocation.getFCost() &&
                                uncheckedSet.get(i).hCost < currentLocation.hCost)) {
                    currentLocation = uncheckedSet.get(i); //stores element with lowest cost
                }
            }

            //removed because it is checked
            uncheckedSet.remove(currentLocation);
            checkedSet.add(currentLocation);

            //if destination is reached
            if (currentLocation == endLocation) {
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

    public static void main(String[] args) {

    }
}
