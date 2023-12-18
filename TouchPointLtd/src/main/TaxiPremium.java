import java.util.List;

public class TaxiPremium extends TaxiDriver{
    public TaxiPremium(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 1, driverName, driverRating, tier, taxiLoc);
    }


    @Override
    public double CalculateFare() {
        int startPrice = 10;
        double rate = 1.5;
        return startPrice + (rate * getTravelTime());
    }
}