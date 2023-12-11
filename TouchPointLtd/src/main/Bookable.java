import java.util.List;

public interface Bookable {

    double CalculateFare();

    static Taxi RemoveFromMap(List<Taxi> allTaxis, int chosenTaxiIndex){
        //stores chosen taxi as chosenTaxi
        Taxi chosenTaxi = allTaxis.get(chosenTaxiIndex);

        //stores taxis current location as variable 'location'
        Location location = chosenTaxi.getTaxiLoc();

        //change taxi location back to road
        location.setDisplayRoad();

        return chosenTaxi;
    }

    static void ReturnToMap(List<Taxi> allTaxis, int chosenTaxiIndex){
        Taxi chosenTaxi = allTaxis.get(chosenTaxiIndex);

        Location location = chosenTaxi.getTaxiLoc();
        location.setDisplayTaxi();
    }

    static void MoveToPassenger(List<Taxi> allTaxis, int chosenTaxiIndex, User passenger, Map map){
        Taxi chosenTaxi = RemoveFromMap(allTaxis, chosenTaxiIndex);
        System.out.println("Driver is on the way.");
        chosenTaxi.printTaxiDetails(chosenTaxi);
        chosenTaxi.moveTaxi(map);
    }
    static void MoveToDestination(List<Taxi> allTaxis, TaxiReg chosenTaxi, User passenger, Map map){
        System.out.println("Taxi has arrived, now leaving with " + passenger.getUsername());
        chosenTaxi.moveTaxi(map);
    }

}