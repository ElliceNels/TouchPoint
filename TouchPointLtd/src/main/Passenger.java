import java.util.InputMismatchException;
import java.util.Scanner;

public class Passenger extends User {
    Scanner in = new Scanner(System.in);

    public Passenger(){
        super();
    }
   /* public findTaxisInRadius(){

    }*/
    public void mainMenuRun(User passenger){

        System.out.println("Name?");
        passenger.setUsername(in.nextLine());

        System.out.println("Enter your location and destination (0)\nList of map areas (1)");
        int choice = in.nextInt();
        switch (choice){
            case 0:
                RegisterPassengerDetails(passenger);
                break;
            case 1:
                placeSearch();
                RegisterPassengerDetails(passenger);
                break;
            default:
                System.out.println("invalid input");
        }
    }

   public void RegisterPassengerDetails(User passenger) {
       boolean validInput = false;

       while (!validInput) {
           try {
               System.out.println("Enter the x and y coordinates of your current location");
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
       in.close();
   }

   public void placeSearch(){
        boolean doneSearch = false;
       while(!doneSearch) {
           in.nextLine();
           System.out.println("What type of location are you looking for?\nOffices (0), Points of Interest (1), Housing (2), Body of Water (3)\nPress anything else to return\n");
           String choice = in.nextLine().trim();
           int count = 1;
           switch (choice) {
               case "0":
                   for (int i = 30; i < 35; i++) {
                       System.out.print("Office " + count + " at " + Map.locations[i][0] + ", ");
                       System.out.print(Map.locations[i][1]);
                       System.out.println();
                       count++;
                   }
                   System.out.println("Press enter\n");
                   break;
               case "1":
                   System.out.println("blah");
                   System.out.println("Press enter\n");
                   break;
               case "2":
                   System.out.println("There are 30 houses in the area. Unfortunately I cannot give you their addresses for security reasons.");
                   System.out.println("Press enter\n");
                   break;
               case "3":
                   System.out.println("There is Blanken Sea at approximately " + Map.locations[55][1] + ", " + Map.locations[55][1]);
                   System.out.println("Press enter\n");
                   break;
               default:
                   System.out.println("\nReturning");
                   doneSearch = true;
                   break;
           }
       }
   }
}
