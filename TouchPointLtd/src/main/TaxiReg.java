import java.util.List;
import java.util.Random;

public class TaxiReg extends Taxi {
    public TaxiReg(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 4, driverName, driverRating, tier, taxiLoc);
    }

    static ListSingleton singleton = ListSingleton.getInstance();
    List<Taxi> allTaxis = singleton.getList();
    User passenger = singleton.getPassenger();

    public Taxi removeFromMap(List<Taxi> allTaxis, int chosenTaxiIndex){
        //stores chosen taxi as chosenTaxi
        TaxiReg chosenTaxi = (TaxiReg) allTaxis.get(chosenTaxiIndex);

        //stores taxis current location as variable 'location'
        Location location = chosenTaxi.getTaxiLoc();

        //change taxi location back to road
        location.setDisplayRoad();

        return chosenTaxi;
    }

    public void MoveToPassenger(List<Taxi> allTaxis, int chosenTaxiIndex, User passenger){
        TaxiReg chosenTaxi = (TaxiReg) removeFromMap(allTaxis, chosenTaxiIndex);
        System.out.println("Driver is on the way.");
        printTaxiDetails(chosenTaxi);
        chosenTaxi.moveTaxi();
    }

    public void MoveToDestination(List<Taxi> allTaxis, TaxiReg chosenTaxi, User passenger){
        System.out.println("Taxi has arrived, now leaving with " + passenger.getUsername());
        chosenTaxi.moveTaxi();
    }

}