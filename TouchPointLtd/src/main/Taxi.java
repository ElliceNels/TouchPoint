import java.util.List;

public class Taxi {
    private String registrationNumber;//individual registration number
    private String carType;//name of taxi type
    private int capacity;//diff capacity depending on type of taxi
    private int driverRating;
    private String driverName;
    private String tier;
    private Location taxiLoc;
    static private int travelTime;

    public Taxi(String registrationNumber, String carType, int capacity, String driverName, int driverRating, String tier, Location taxiLoc) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.capacity = capacity;
        this.driverName = driverName;
        this.driverRating = driverRating;
        this.tier = tier;
        this.taxiLoc = taxiLoc;
    }

    public static void moveTaxi(Map map){
        List<Location> path = AStarAlgorithm.findPath(map);
        setTravelTime(0);
        //ensures there is an actual path
        if (path != null) {
            for (Location location : path) {
                System.out.println("(" + location.x + ", " + location.y + ")");
                travelTime++;
            }
        } else {
            System.out.println("Your location cannot be accessed by taxi.");
        }
    }

    public static void printTaxiDetails(Taxi chosenTaxi){
        System.out.println("Taxi tier is " + chosenTaxi.getTier());
        System.out.println("Driver name: " + chosenTaxi.getDriverName());
        System.out.println("Driver rating: " + chosenTaxi.getDriverRating());
        System.out.println("Registration number: " + chosenTaxi.getRegistrationNumber());
        System.out.println("Car brand: " + chosenTaxi.getCarType());
        System.out.println("Capacity: " + chosenTaxi.getCapacity() + " seats");
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

    public Location getTaxiLoc() {
        return taxiLoc;
    }

    public void setTaxiLoc(Location taxiLoc) {
        this.taxiLoc = taxiLoc;
    }

    public static int getTravelTime() {
        return travelTime;
    }

    public static void setTravelTime(int travelTime) {
        Taxi.travelTime = travelTime;
    }
}