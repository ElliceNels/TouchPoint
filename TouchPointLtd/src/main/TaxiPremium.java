import java.util.List;

public class TaxiPremium extends TaxiDriver implements Bookable{
    public TaxiPremium(String registrationNumber, String carType, String driverName, int driverRating, String tier, Location taxiLoc) {
        super(registrationNumber, carType, 1, driverName, driverRating, tier, taxiLoc);
    }


    @Override
    public double CalculateFare() {
        int startPrice = 10;
        double rate = 1.5;
        return startPrice + (rate * getTravelTime());
    }

    @Override
    public void ReturnToMap(List<TaxiDriver> allTaxis, int chosenTaxiIndex) {

    }

    @Override
    public void MoveToDestination(List<TaxiDriver> allTaxis, TaxiReg chosenTaxi, User passenger, Map map) {

    }
}