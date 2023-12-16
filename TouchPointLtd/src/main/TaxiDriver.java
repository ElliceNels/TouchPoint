import java.util.List;

public abstract class TaxiDriver extends User implements Bookable{
    private String registrationNumber;//individual registration number
    private String carType;//name of taxi type
    private int capacity;//diff capacity depending on type of taxi
    private int driverRating;
    private String driverName;
    private String tier;
    private static Location taxiLoc;
    static private int travelTime;
    ListSingleton singleton = ListSingleton.getInstance();

    public TaxiDriver(String registrationNumber, String carType, int capacity, String driverName, int driverRating, String tier, Location taxiLoc) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.capacity = capacity;
        this.driverName = driverName;
        this.driverRating = driverRating;
        this.tier = tier;
        TaxiDriver.taxiLoc = taxiLoc;
    }



    public static void printTaxiDetails(TaxiDriver chosenTaxi){
        System.out.println(chosenTaxi.getTier());
        System.out.println("Driver name: " + chosenTaxi.getDriverName());
        System.out.println("Driver rating: " + chosenTaxi.getDriverRating());
        System.out.println("Registration number: " + chosenTaxi.getRegistrationNumber());
        System.out.println("Car brand: " + chosenTaxi.getCarType());
        System.out.println("Capacity: " + chosenTaxi.getCapacity() + " seats");
        System.out.println();

    }

    public TaxiDriver RemoveFromMap(List<TaxiDriver> allTaxis, int chosenTaxiIndex){
        //stores chosen taxi as chosenTaxi
        TaxiDriver chosenTaxi = allTaxis.get(chosenTaxiIndex);

        //stores taxis current location as variable 'location'
        Location location = chosenTaxi.getTaxiLoc();

        //change taxi location back to road
        //location.setDisplayRoad();

        return chosenTaxi;
    }

    public void ReturnToMap(int chosenTaxiIndex){
        Location location = singleton.chooseTaxi().getTaxiLoc();

        //location.setDisplayTaxi();
    }

    public void MoveToPassenger(User passenger, Map map){
        System.out.println(driverName + " is on the way.");
        //printTaxiDetails();
        AStarAlgorithm aStar = new AStarAlgorithm(20, 20);
        aStar.roadMapCoordinates(map);
        aStar.aStarRun(getTaxiLoc(), passenger.getPickupPoint());
        System.out.println(driverName + " has arrived, now leaving with " + passenger.getUsername());
    }

    public void MoveToDestination( User passenger, Map map){
        AStarAlgorithm aStar = new AStarAlgorithm(20, 20);
        aStar.roadMapCoordinates(map);
        aStar.aStarRun(passenger.getPickupPoint(), passenger.getClosestDestination());
        System.out.println("Destination reached. Rate " + driverName + ":");
        //chosenTaxi.moveTaxi(map);

    }

    public void taxiSequence(Passenger passenger, Map map){
        //RemoveFromMap(allTaxis, chosenTaxiIndex);
        MoveToPassenger(passenger, map);
        MoveToDestination(passenger, map);
    }

    public double CalculateFare() {
        int startPrice = 6;
        double rate = 1.2;
        return startPrice + (rate * getTravelTime());
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public static Location getTaxiLoc() {
        return taxiLoc;
    }

    public static void setTaxiLoc(Location taxiLoc) {
        TaxiDriver.taxiLoc = taxiLoc;
    }

    public static int getTravelTime() {
        return travelTime;
    }

    public static void setTravelTime(int travelTime) {
        TaxiDriver.travelTime = travelTime;
    }
}