import static java.lang.Thread.sleep;

public class AStarAlgorithm extends Location {

   ListSingleton singleton = ListSingleton.getInstance();
   List<TaxiDriver> allTaxis = singleton.getList();
   User passenger = singleton.getPassenger();


    int ROWS = 20;
    int COLS = 20;

    //roadMap with obstacles represented as null
    Location[][] roadMap = new Location[ROWS][COLS];
    static int movementCost = 1;

    public AStarAlgorithm(int x, int y) {
        super(x, y);
    }



    public List<Location> getAdjacents(Location location) {
        List<Location> adjacents = new CustomArrayList<>();
        // Logic to get adjacent nodes based on the roadMap boundaries
        // Define possible moves (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = location.x + dx[i];
            int newY = location.y + dy[i];

            // Check if the new coordinates are within roadMap boundaries and adds to adjacents
            if (isValidCoord(newX, newY)) {
                adjacents.add(roadMap[newX][newY]);
            }
        }
        //System.out.println(adjacents + " has been gotten from adjacents");
        return adjacents;
    }

    public boolean isValidCoord(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS && roadMap[x][y] != null;
        //Coordinate: not = to 0, between the number of rows and columns and is not = to null(obstacle)
    }

    public int calculateHCost(Location location, Location endLocation) {
        // Calculate heuristic (h) with Manhattan distance from current location to endLocation (estimation)
        return Math.abs(location.x - endLocation.x) + Math.abs(location.y - endLocation.y);

    }

    public List<Location> findPath(Location startLocation, Location endLocation) {
        List<Location> uncheckedList = new CustomArrayList<>();
        List<Location> checkedList = new CustomArrayList<>();
        uncheckedList.add(startLocation);

        while (!uncheckedList.isEmpty()) { //keeps going til the unchecked list is empty (everything is checked)

            Location currentLocation = uncheckedList.get(0);
            //to find the lowest total cost (f and h but f is considered first)
            for (int i = 1; i < uncheckedList.size(); i++) {
                if (uncheckedList.get(i).getFCost() < currentLocation.getFCost() ||
                        (uncheckedList.get(i).getFCost() == currentLocation.getFCost() &&
                                uncheckedList.get(i).hCost < currentLocation.hCost)) {
                    currentLocation = uncheckedList.get(i); //stores element with the lowest cost
                }
            }


            //removed because it is checked
            uncheckedList.remove(currentLocation);
            checkedList.add(currentLocation);

            //if destination is reached
            if (currentLocation.getX() == endLocation.getX() && currentLocation.getY() == endLocation.getY()) { //ISSUE
                return reconstructPath(currentLocation);
            }

            List<Location> adjacents = getAdjacents(currentLocation);
            for (int i = 0; i < adjacents.size(); i++) {
                Location adjacent = adjacents.get(i);

                // To iterate through and check if adjacent is in the list
                boolean alreadyChecked = false;
                for (int j = 0; j < checkedList.size(); j++) {
                    Location checkedLocation = checkedList.get(j);
                    if (checkedLocation.equals(adjacent)) {
                        alreadyChecked = true;
                        break;
                    }
                }

                if (adjacent == null || alreadyChecked) {
                    continue; // Skips the rest of the code if there's an invalid adjacent
                }

                int newCost = currentLocation.gCost + movementCost; // Cost from currentLocation to adjacent
                if (newCost < adjacent.gCost || !uncheckedList.contains(adjacent)) {
                    adjacent.gCost = newCost;
                    adjacent.hCost = calculateHCost(adjacent, endLocation);
                    adjacent.parent = currentLocation;

                    if (!uncheckedList.contains(adjacent)) {
                        uncheckedList.add(adjacent);
                    }
                }
            }

        }
        return null;
    }

    static List<Location> reconstructPath(Location current) {
        List<Location> path = new CustomArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        int start = 0;
        int end = path.size() - 1;
        while (start < end) {
            Location temp = path.get(start);
            path.set(start, path.get(end));
            path.set(end, temp);

            start++;
            end--;
        }
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

    public void printRoadMap(){
        for (int i = 0; i < roadMap.length - 1; i++){
            System.out.println();
            for (int j = 0; j < roadMap.length - 1; j++) {
                System.out.print(roadMap[i][j]);
            }
        }
    }

    public void aStarRun(Location startLocation, Location endLocation, String name)  {
        int time = 0;
        List<Location> path = findPath(startLocation, endLocation);
        //ensures there is an actual path
        if (path != null) {
            for (int i = 0; i < path.size(); i++) {
                Location location = path.get(i);

                // For loop used to access the TaxiDriver class
                for (int j = 0; j < allTaxis.size(); j++) {
                    TaxiDriver taxi = allTaxis.get(j);
                    if (taxi.getDriverName().equals(name)) {
                        System.out.println("(" + location.x + ", " + location.y + ")");
                        time++;
                        // Ensures the current location of the taxi is right
                        if (location.isVisited()) {
                            location.setTaxiPresent(true);
                            location.setRoadPresent(false);
                        }
                        taxi.setTaxiLoc(location);
                        Map.setGrid(location);
                        location.setVisited(true);
                        location.setTaxiPresent(true);
                        singleton.getMap().displayMap();
                        location.setRoadPresent(true);
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("sorry, small break");
                        }
                    }
                }
            }
            System.out.println("Arrived");
            TaxiDriver.setTravelTime(time);
        } else {
            System.out.println("Driver is already here.");
        }
    }

}
