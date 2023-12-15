import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Passenger extends User {


    ListSingleton singleton = ListSingleton.getInstance();
    Scanner in = new Scanner(System.in);
    public void mainMenuRun(User passenger, Map map) {
        System.out.println("Name?");
        passenger.setUsername(in.nextLine());

        System.out.println("Enter your location and destination to book a taxi (0)\nSee a list of map areas (1)");
        int choice = in.nextInt();
        switch (choice) {
            case 0:
                RegisterPassengerDetails(passenger);
                ChooseAPickupRoad(map, passenger);
                ChooseADestinationRoad(map, passenger);
                ChooseATaxi(passenger, map);
                break;
            case 1:
                placeSearch();
                RegisterPassengerDetails(passenger);
                ChooseAPickupRoad(map, passenger);
                ChooseADestinationRoad(map, passenger);
                break;
            default:
                System.out.println("invalid input");
        }
    }

    public void RegisterPassengerDetails(User passenger) {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter the x and y coordinates of your current Location");
                int xCoord = in.nextInt();
                int yCoord = in.nextInt();
                passenger.setCurrentLocation(new Location(xCoord, yCoord));

                System.out.println("Enter the x and y coordinates of your destination");
                int DxCoord = in.nextInt();
                int DyCoord = in.nextInt();
                passenger.setDestination(new Location(DxCoord, DyCoord));
                validInput = true;
                System.out.println(passenger.getUsername() + " is at " + passenger.getCurrentLocation().getX() + ", " + passenger.getCurrentLocation().getY() + " and wants to go to " + passenger.getDestination().getX() + ", " + passenger.getDestination().getY());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                in.nextLine();
            }
        }
    }

    public void placeSearch() {
        Map map = new Map(20, 20);
        map.storeMapLocations();
        boolean doneSearch = false;
        while (!doneSearch) {
            in.nextLine();
            System.out.println("What type of location are you looking for?\nOffices (0), Points of Interest (1), Housing (2), Body of Water (3)\nPress anything else to return\n");
            String choice = in.nextLine().trim();
            int count = 1;
            switch (choice) {
                case "0":
                    for (int i = 30; i < 35; i++) {
                        Location location = map.mapLocations.get(i);
                        System.out.print("Office " + count + " at " + location.getX() + ", ");
                        System.out.print(location.getY());
                        System.out.println();
                        count++;
                    }
                    System.out.println("Press enter\n");
                    break;
                case "1":
                    System.out.println("Places of Interest:\n");
                    Location location = map.mapLocations.get(68);
                    Location location2 = map.mapLocations.get(80);
                    Location location3 = map.mapLocations.get(87);
                    System.out.println("La Ville Lumiere at " + location.getX() + ", " + location.getY());
                    System.out.println("Steve's Golf & Country Club at " + location2.getX() + ", " + location2.getY());
                    System.out.println("Cho's Barbecue & Foot Massage at " + location3.getX() + ", " + location3.getY());
                    System.out.println("Press enter\n");
                    break;
                case "2":
                    System.out.println("There are 30 houses in the area. Unfortunately I cannot give you their addresses for security reasons.");
                    System.out.println("Press enter\n");
                    break;
                case "3":
                    System.out.println("There is Blanken Sea at approximately " + map.mapLocations.get(55).getX() + ", " + map.mapLocations.get(55).getY() + " to " + map.mapLocations.get(61).getX() + ", " + map.mapLocations.get(61).getY());
                    System.out.println("Press enter\n");
                    break;
                default:
                    System.out.println("\nReturning");
                    doneSearch = true;
                    break;
            }
        }
    }
    public void ChooseAPickupRoad(Map map, User passenger) {
        Location pickupPassenger = new Location(passenger.getCurrentLocation());
        int roadRadius = 3;
        outerLoop:
        // Label for the outer loop
        if (passenger.getCurrentLocation() != null && passenger.getCurrentLocation().roadPresent) {
            passenger.setPickupPoint(passenger.getCurrentLocation());
            ChooseADestinationRoad(map, passenger);
        } else {
            for (int i = pickupPassenger.getX() - roadRadius; i <= pickupPassenger.getX() + roadRadius; i++) {
                for (int j = pickupPassenger.getY() - roadRadius; j <= pickupPassenger.getY() + roadRadius; j++) {
                    if (i >= 0 && i < 20 && j >= 0 && j < 20) {
                        Location roadLocation = map.getGrid()[i][j];
                        // Check if the symbol at   the current location is a taxi symbol
                        if (roadLocation != null && roadLocation.roadPresent) {
                            passenger.setPickupPoint(new Location(i, j));
                            System.out.println("Pickup point is (" + i + ", " + j + ")");
                            break outerLoop; // Break out of the outer loop when a taxi is found
                        }
                    }
                }
            }
        }
    }

    public void ChooseADestinationRoad(Map map, User passenger) {
        Location pickupPassenger = new Location(passenger.getDestination());
        int roadRadius = 3;
        outerLoop:
        // Label for the outer loop
        if (passenger.getDestination() != null && passenger.getDestination().roadPresent) {
            passenger.setClosestDestination(new Location(passenger.getDestination()));
            ChooseATaxi(passenger, map);
        } else {
            for (int i = pickupPassenger.getX() - roadRadius; i <= pickupPassenger.getX() + roadRadius; i++) {
                for (int j = pickupPassenger.getY() - roadRadius; j <= pickupPassenger.getY() + roadRadius; j++) {
                    if (i >= 0 && i < 20 && j >= 0 && j < 20) {
                        Location roadLocation = map.getGrid()[i][j];
                        // Check if the symbol at the current location is a taxi symbol
                        if (roadLocation != null && roadLocation.roadPresent) {
                            passenger.setClosestDestination(new Location(i, j));
                            System.out.println("The taxi will bring you to (" + i + ", " + j + ")");
                            break outerLoop; // Break out of the outer loop when a taxi is found
                        }
                    }
                }
            }
        }
    }

    public void ChooseATaxi(User passenger, Map map) {
        Location searchCentre = passenger.getCurrentLocation();
        int r = passenger.getPreferredRadius();//set as r to shorten code
        for (int i = searchCentre.getX() - r; i <= searchCentre.getX() + r; i++) {
            for (int j = searchCentre.getY() - r; j <= searchCentre.getY() + r; j++) {
                if (i >= 0 && i < 20 && j >= 0 && j < 20) { // Ensure the indices are within bounds
                    Location taxiLocations = map.getGrid()[i][j];
                    // Check if the symbol at the current location is a taxi symbol
                    if (taxiLocations.taxiPresent) {
                        List<TaxiDriver> allTaxis = singleton.getList();
                        for(TaxiDriver taxiDriver : allTaxis){
                           int distance = calculateDistance(taxiDriver.getTaxiLoc(), passenger.getClosestDestination());
                            if (distance < 4){
                                System.out.println(allTaxis);
                            }
                        }
                    }
                }
            }
        }in.close();
    }
    private int calculateDistance(Location loc1, Location loc2) {
        // Calculate distance between two locations
        int dx = loc1.getX() - loc2.getX();
        int dy = loc1.getY() - loc2.getY();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}