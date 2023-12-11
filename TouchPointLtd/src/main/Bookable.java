import java.util.List;

public interface Bookable {



    public static Taxi RemoveFromMap(List<Taxi> allTaxis, int chosenTaxiIndex){
        //stores chosen taxi as chosenTaxi
        Taxi chosenTaxi = allTaxis.get(chosenTaxiIndex);

        //stores taxis current location as variable 'location'
        Location location = chosenTaxi.getTaxiLoc();

        //change taxi location back to road
        location.setDisplayRoad();

        return chosenTaxi;
    }

    //public void ReturnToMap();

    public static void MoveToPassenger(List<Taxi> allTaxis, int chosenTaxiIndex, User passenger){
        Taxi chosenTaxi = RemoveFromMap(allTaxis, chosenTaxiIndex);
        System.out.println("Driver is on the way.");
        chosenTaxi.printTaxiDetails(chosenTaxi);
        chosenTaxi.moveTaxi();
    }
    public static void MoveToDestination(List<Taxi> allTaxis, TaxiReg chosenTaxi, User passenger){
        System.out.println("Taxi has arrived, now leaving with " + passenger.getUsername());
        chosenTaxi.moveTaxi();
    }

    public double CalculateFare();


}