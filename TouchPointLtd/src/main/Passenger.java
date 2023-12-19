
import java.util.Scanner;
public class Passenger extends User {
    Scanner in = new Scanner(System.in);
    public void mainMenuRun(User passenger, Map map) throws InterruptedException {
        boolean signUp = false;
        System.out.println("Name?");
        passenger.setUsername(in.nextLine());

        while (!signUp) {
            System.out.println("Enter your location and destination to book a taxi (0)\nSee a list of map areas (1)");
            if(in.hasNextInt()) {
                int choice = in.nextInt();
                if (choice == 1) {
                    placeSearch(map);
                }
                        RegisterPassengerDetails(passenger);
                        ChooseAPickupRoad(map, passenger);
                        ChooseADestinationRoad(map, passenger);
                        signUp = true;
            }else{
                in.next();
                System.out.println("Please enter an integer listed above.");
            }
        }
    }

    public void RegisterPassengerDetails(User passenger) throws InterruptedException {
        boolean validLocation = false;
        boolean validDestination = false;

        // Input for current location
        System.out.println("Enter the x and y coordinates of your current location");
        int xCoord;
        int yCoord;

        while (!validLocation) {
            if (in.hasNextInt()) {
                xCoord = in.nextInt();
                if (in.hasNextInt()) {
                    yCoord = in.nextInt();

                    if (xCoord >= 0 && xCoord <= 19 && yCoord >= 0 && yCoord <= 19) {//check if inout is within parameters
                        passenger.setCurrentLocation(new Location(xCoord, yCoord));
                        validLocation = true;
                    } else {
                        System.out.println("Please enter valid coordinates between 0 and 19.");
                    }
                } else {
                    System.out.println("Please enter valid integer coordinates for both x and y.");
                    in.next(); // Consume the invalid input
                }
            } else {
                System.out.println("Please enter valid integer coordinates for both x and y.");
                in.next();
            }
        }

        // Input for destination
        int DxCoord;
        int DyCoord;

        while (!validDestination) {
            System.out.println("Enter the x and y coordinates of your destination");

            if (in.hasNextInt()) {
                DxCoord = in.nextInt();
                if (in.hasNextInt()) {
                    DyCoord = in.nextInt();

                    if (DxCoord >= 0 && DxCoord <= 19 && DyCoord >= 0 && DyCoord <= 19) {
                        passenger.setDestination(new Location(DxCoord, DyCoord));
                        validDestination = true;
                    } else {
                        System.out.println("Please enter valid coordinates between 0 and 19.");
                    }
                } else {
                    System.out.println("Please enter valid integer coordinates for both x and y.");
                    in.next(); // Consume the invalid input
                }
            } else {
                System.out.println("Please enter valid integer coordinates for both x and y.");
                in.next();
            }
        }

        System.out.println(passenger.getUsername() + " is at " + passenger.getCurrentLocation().getX() + ", " +
                passenger.getCurrentLocation().getY() + " and wants to go to " + passenger.getDestination().getX() +
                ", " + passenger.getDestination().getY());
        Thread.sleep(3000);
    }



    public void placeSearch(Map map) {
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
                    System.out.println("Che's Barbecue & Foot Massage at " + location3.getX() + ", " + location3.getY());
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
    public void ChooseAPickupRoad(Map map, User passenger) throws InterruptedException {
        Location pickupPassenger = new Location(passenger.getCurrentLocation());
        int roadRadius = 3;
        outerLoop:
        // Label for the outer loop
        if (passenger.getCurrentLocation() != null && passenger.getCurrentLocation().roadPresent) {
            passenger.setPickupPoint(passenger.getCurrentLocation());
            //ChooseADestinationRoad(map, passenger);
        } else {
            for (int i = pickupPassenger.getX() - roadRadius; i <= pickupPassenger.getX() + roadRadius; i++) {
                for (int j = pickupPassenger.getY() - roadRadius; j <= pickupPassenger.getY() + roadRadius; j++) {
                    if (i >= 0 && i < 20 && j >= 0 && j < 20) {
                        Location roadLocation = map.getGrid()[i][j];
                        // Check if the symbol at   the current location is a taxi symbol
                        if (roadLocation != null && roadLocation.roadPresent) {
                            passenger.setPickupPoint(new Location(i, j));
                            System.out.println("\nPickup point is (" + i + ", " + j + ")");
                            break outerLoop; // Break out of the outer loop when a taxi is found
                        }
                    }
                }
            }
        }
    }

    public void ChooseADestinationRoad(Map map, User passenger) throws InterruptedException {
        Location destPassenger = new Location(passenger.getDestination());
        int roadRadius = 3;
        outerLoop:
        // Label for the outer loop
        if (passenger.getDestination() != null && passenger.getDestination().roadPresent) {
            passenger.setClosestDestination(passenger.getDestination());
        } else {
            for (int i = destPassenger.getX() - roadRadius; i <= destPassenger.getX() + roadRadius; i++) {
                for (int j = destPassenger.getY() - roadRadius; j <= destPassenger.getY() + roadRadius; j++) {
                    if (i >= 0 && i < 20 && j >= 0 && j < 20) {
                        Location roadLocation = map.getGrid()[i][j];
                        // Check if the symbol at   the current location is a taxi symbol
                        if (roadLocation != null && roadLocation.roadPresent) {
                            passenger.setClosestDestination(new Location(i, j));
                            System.out.println("The taxi will bring you to (" + i + ", " + j + ")");
                            Thread.sleep(2000);
                            break outerLoop; // Break out of the outer loop when a taxi is found
                        }
                    }
                }
            }
        }
    }
}