import java.util.List;

public interface Bookable {

    double CalculateFare();

    public TaxiDriver RemoveFromMap(List<TaxiDriver> allTaxis, int chosenTaxiIndex);

    public void ReturnToMap(List<TaxiDriver> allTaxis);

    public void MoveToPassenger( User passenger, Map map);

    public void MoveToDestination(User passenger, Map map);

}