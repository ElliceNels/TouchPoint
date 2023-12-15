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

    public TaxiDriver(String registrationNumber, String carType, int capacity, String driverName, int driverRating, String tier, Location taxiLoc) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.capacity = capacity;
        this.driverName = driverName;
        this.driverRating = driverRating;
        this.tier = tier;
        this.taxiLoc = taxiLoc;
    }



    public static void printTaxiDetails(TaxiDriver chosenTaxi){
        System.out.println("Taxi tier is " + chosenTaxi.getTier());
        System.out.println("Driver name: " + chosenTaxi.getDriverName());
        System.out.println("Driver rating: " + chosenTaxi.getDriverRating());
        System.out.println("Registration number: " + chosenTaxi.getRegistrationNumber());
        System.out.println("Car brand: " + chosenTaxi.getCarType());
        System.out.println("Capacity: " + chosenTaxi.getCapacity() + " seats");
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

    public void ReturnToMap(List<TaxiDriver> allTaxis, int chosenTaxiIndex){
        TaxiDriver chosenTaxi = allTaxis.get(chosenTaxiIndex);

        Location location = chosenTaxi.getTaxiLoc();
        //location.setDisplayTaxi();
    }

    public void MoveToPassenger(List<TaxiDriver> allTaxis, int chosenTaxiIndex, User passenger, Map map){
        TaxiDriver chosenTaxi = RemoveFromMap(allTaxis, chosenTaxiIndex);
        System.out.println("Driver is on the way.");
        chosenTaxi.printTaxiDetails(chosenTaxi);
    }

    public void MoveToDestination(List<TaxiDriver> allTaxis, TaxiReg chosenTaxi, User passenger, Map map){
        System.out.println("Taxi has arrived, now leaving with " + passenger.getUsername());
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