import java.util.List;

public interface Bookable {

    double CalculateFare();
    public void ReturnToMap(List<TaxiDriver> allTaxis);
    public void MoveToPassenger( User passenger, Map map);
    public void MoveToDestination(User passenger, Map map);

}