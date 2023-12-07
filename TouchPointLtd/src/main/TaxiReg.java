import java.util.List;
import java.util.Random;

public class TaxiReg extends Taxi {
    public TaxiReg(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 4, driverName, driverRating, tier, taxiLoc);
    }

    ListSingleton singleton = ListSingleton.getInstance();
    List<Taxi> allTaxis = singleton.getList();

    public void removeFromMap(){

    }

//    public void MoveToPassenger(int taxiIndex){
//        Taxi selectedTaxi = allTaxis.get(taxiIndex);
//        selectedTaxi.setTaxiLoc(passenger.get);
//    }
}