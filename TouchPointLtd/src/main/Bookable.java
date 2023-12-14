import java.util.List;

public interface Bookable {

    double CalculateFare();

    public TaxiDriver RemoveFromMap(List<TaxiDriver> allTaxis, int chosenTaxiIndex);

    public void ReturnToMap(List<TaxiDriver> allTaxis, int chosenTaxiIndex);

    public void MoveToPassenger(List<TaxiDriver> allTaxis, int chosenTaxiIndex, User passenger, Map map);

    public void MoveToDestination(List<TaxiDriver> allTaxis, TaxiReg chosenTaxi, User passenger, Map map);

}