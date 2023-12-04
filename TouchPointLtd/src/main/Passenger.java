import java.util.InputMismatchException;
import java.util.Scanner;

public class Passenger extends User {

    public Passenger(){
        super();
    }
   /* public findTaxisInRadius(){

    }*/
   public static void RegisterPassengerDetails(User passenger) {//User does one time login.No need to store user info as no database is needed.
       // This handles user login, calling a taxi and inputting designated area (too much to handle, will be split)
       Scanner in = new Scanner(System.in);

       System.out.println("Name?");
       passenger.setUsername(in.nextLine());
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

}
