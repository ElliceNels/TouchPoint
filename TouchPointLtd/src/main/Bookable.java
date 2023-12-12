import java.util.List;

public interface Bookable {

    double CalculateFare();

    public Taxi RemoveFromMap(List<Taxi> allTaxis, int chosenTaxiIndex);

    public void ReturnToMap(List<Taxi> allTaxis, int chosenTaxiIndex);

    public void MoveToPassenger(List<Taxi> allTaxis, int chosenTaxiIndex, User passenger, Map map);

    public void MoveToDestination(List<Taxi> allTaxis, TaxiReg chosenTaxi, User passenger, Map map);

}