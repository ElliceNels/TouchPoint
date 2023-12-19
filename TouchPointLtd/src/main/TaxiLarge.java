
public class TaxiLarge extends TaxiDriver {
    public TaxiLarge(String registrationNumber, String carType, String driverName, double driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 6, driverName, driverRating, tier, taxiLoc);
    }

    @Override
    public double CalculateFare() {
        int startPrice = 7;
        double rate = 1.2;
        return startPrice + (rate * getTravelTime());
    }
}