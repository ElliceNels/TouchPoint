import java.util.List;

public class TaxiLarge extends TaxiDriver implements Bookable {
    public TaxiLarge(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 6, driverName, driverRating, tier, taxiLoc);
    }

    @Override
    public double CalculateFare() {
        int startPrice = 7;
        double rate = 1.2;
        return startPrice + (rate * getTravelTime());
    }

    @Override
    public void ReturnToMap(List<TaxiDriver> allTaxis, int chosenTaxiIndex) {

    }

    @Override
    public void MoveToDestination(List<TaxiDriver> allTaxis, TaxiReg chosenTaxi, User passenger, Map map) {

    }
}