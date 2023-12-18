import java.util.List;

public class TaxiReg extends TaxiDriver {
    public TaxiReg(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 4, driverName, driverRating, tier, taxiLoc);
    }


    @Override
    public void ReturnToMap(List<TaxiDriver> allTaxis, int chosenTaxiIndex) {

    }

    @Override
    public void MoveToDestination(List<TaxiDriver> allTaxis, TaxiReg chosenTaxi, User passenger, Map map) {

    }

    //static ListSingleton singleton = ListSingleton.getInstance();
    //List<Taxi> allTaxis = singleton.getList();
    //User passenger = singleton.getPassenger();

}
