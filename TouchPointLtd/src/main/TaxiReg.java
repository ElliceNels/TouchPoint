import java.util.List;
import java.util.Random;

public class TaxiReg extends Taxi implements Bookable{
    public TaxiReg(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 4, driverName, driverRating, tier, taxiLoc);
    }

    //static ListSingleton singleton = ListSingleton.getInstance();
    //List<Taxi> allTaxis = singleton.getList();
    //User passenger = singleton.getPassenger();

    @Override
    public double CalculateFare() {
        int startPrice = 6;
        double rate = 1.2;
        return startPrice + (rate * getTravelTime());
    }
}