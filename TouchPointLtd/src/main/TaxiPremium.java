public class TaxiPremium extends Taxi {
    public TaxiPremium(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 1, driverName, driverRating, tier, taxiLoc);
    }

}