import java.util.List;

public class TaxiReg extends TaxiDriver {
    public TaxiReg(String registrationNumber, String carType, String driverName, double driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 4, driverName, driverRating, tier, taxiLoc);
    }
}
