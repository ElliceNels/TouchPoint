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

        System.out.println("Enter your location and destination(0)\nList of map areas (1)");
        int choice = in.nextInt();
        switch (choice){
            case 0:
                RegisterPassengerDetails(passenger);
                break;
            case 1:
                placeSearch();
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
       System.out.println("What type of location are you looking for?\nOffices(0), Points of Interest(1), Housing(2), Body of Water(3)");
       int choice = in.nextInt();
       switch (choice){
           case 0:
               for (int i = 30; i < 35; i++) {
                   int officeX = Map.locations[i][0];
                   int officeY = Map.locations[i][1];
                   //Map.getGrid([officeX][officeY]);
                   //grid[officeX][officeY].setDisplayOffice();
               }
               break;
           case 1:
               System.out.println("blah");
               break;
           case 2:
               System.out.println("There are 30 houses in the area. Unfortunately I cannot give you their addresses.\nHere is the map of houses");

               break;
           case 3:
               System.out.println("There is Blanken Sea at approximately " + Map.locations[55][1]);
               break;
           default:
               System.out.println("invalid input");
       }
   }
}
