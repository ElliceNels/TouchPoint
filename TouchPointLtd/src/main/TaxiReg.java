import java.util.List;
import java.util.Random;

public class TaxiReg extends Taxi {
    public TaxiReg(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 4, driverName, driverRating, tier, taxiLoc);
    }

    ListSingleton singleton = ListSingleton.getInstance();
    List<Taxi> allTaxis = singleton.getList();
    User passenger = singleton.getPassenger();

    public static void removeFromMap(List<Taxi> allTaxis){

    }

    public static void MoveToPassenger(List<Taxi> allTaxis, int taxiIndex, User passenger){
        removeFromMap(allTaxis);
        Taxi selectedTaxi = allTaxis.get(taxiIndex);
        selectedTaxi.setTaxiLoc(passenger.getCurrentLocation());
    }
}