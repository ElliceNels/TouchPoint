import java.util.List;
import java.util.Random;

public class TaxiReg extends Taxi {
    public TaxiReg(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 4, driverName, driverRating, tier, taxiLoc);
    }

}
