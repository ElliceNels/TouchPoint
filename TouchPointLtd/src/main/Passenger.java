import java.util.InputMismatchException;
import java.util.Scanner;

public class Passenger extends User {

    public Passenger(){
        super();
    }
   /* public findTaxisInRadius(){

    }*/
   public static void Login() {//User does one time login.No need to store user info as no database is needed.
       // This handles user login, calling a taxi and inputting designated area (too much to handle, will be split)
       Scanner in = new Scanner(System.in);
       User passenger = new Passenger();

       System.out.println("Name?");
       passenger.setUsername(in.nextLine());
    try {
        System.out.println("Enter x and y coord of current location");
        int xCoord = in.nextInt();
        int yCoord = in.nextInt();
        passenger.setCurrentLocation(new Location(xCoord, yCoord));

        System.out.println("Enter x and y coord of you destination");
        int DxCoord = in.nextInt();
        int DyCoord = in.nextInt();
        passenger.setDestination(new Location(DxCoord, DyCoord));
    } catch(InputMismatchException e){
        System.out.println("Invalid input");
    }
    try {
        System.out.println(passenger.getUsername() + " is at " + passenger.getCurrentLocation().getX() + ", " + passenger.getCurrentLocation().getY() + " and wants to go to " + passenger.getDestination().getX() + ", " + passenger.getDestination().getY());
        in.close();
    } catch (NullPointerException e){
        System.out.println("No valid input to continue with");
    }

   }

}
