import java.io.*;
import java.nio.file.StandardCopyOption;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class TaxiDriver implements Bookable{
    Scanner in = new Scanner(System.in);
    private String registrationNumber;//individual registration number
    private String carType;//name of taxi type
    private int capacity;//diff capacity depending on type of taxi
    private double   driverRating;
    private String driverName;
    private String tier;
    private Location taxiLoc;
    static private int travelTime;
    ListSingleton singleton = ListSingleton.getInstance();

    public TaxiDriver(String registrationNumber, String carType, int capacity, String driverName, double driverRating, String tier, Location taxiLoc) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.capacity = capacity;
        this.driverName = driverName;
        this.driverRating = driverRating;
        this.tier = tier;
        this.taxiLoc = taxiLoc;
    }



    public static void printTaxiDetails(TaxiDriver chosenTaxi){
        System.out.println(chosenTaxi.getTier());
        System.out.println("Driver name: " + chosenTaxi.getDriverName());
        System.out.println("Driver rating: " + chosenTaxi.getDriverRating());
        System.out.println("Registration number: " + chosenTaxi.getRegistrationNumber());
        System.out.println("Car brand: " + chosenTaxi.getCarType());
        System.out.println("Capacity: " + chosenTaxi.getCapacity() + " seats\n");

    }

    public void MoveToPassenger(User passenger, Map map){
        System.out.println(driverName + " is on the way.");
        AStarAlgorithm aStar = new AStarAlgorithm(20, 20);
        aStar.roadMapCoordinates(map);
        aStar.aStarRun(getTaxiLoc(), passenger.getPickupPoint(), getDriverName());
        System.out.println(driverName + " has arrived, now leaving with " + passenger.getUsername());
    }

    public void MoveToDestination( User passenger, Map map) {
        AStarAlgorithm aStar = new AStarAlgorithm(20, 20);
        aStar.roadMapCoordinates(map);
        System.out.println(getTaxiLoc().getX() +", "+ getTaxiLoc().getY());
        passenger.setCurrentLocation(passenger.getPickupPoint()); //set the passenger to be at the pickup point
        aStar.aStarRun(passenger.getPickupPoint(), passenger.getClosestDestination(), getDriverName());
        passenger.setCurrentLocation(passenger.getClosestDestination()); //set passenger at their destination
        passenger.getDestination().setPassengerDestPresent(false);
    }

    public void driverRating() throws IOException {
        while (true) {
            try {
                System.out.print("Enter driver rating (1-5): ");
                double rating = in.nextDouble();

                if (rating >= 1 && rating <= 5) {
                    updateRating(driverName, rating);
                    break; // Exit the loop if a valid rating is entered
                } else {
                    System.out.println("Please enter a number between '1' and '5'");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                in.nextLine(); // Consume the invalid input to avoid an infinite loop
            }
        }
    }

    public void taxiSequence(Passenger passenger, Map map) throws IOException {
        singleton.RemoveFromMap();
        MoveToPassenger(passenger, map);
        MoveToDestination(passenger, map);
        driverRating();
        roundFare(CalculateFare());
        map.getTaxiDrivers(passenger.getDestination());
        singleton.ReturnToMap();
        System.out.println();
        System.out.println("Journey Finished.\nTouchPoint: One Tap Away From Home");
        singleton.getMap().displayMap();
    }

    public double CalculateFare() {
        int startPrice = 6;
        double rate = 1.2;
        double x = startPrice + (rate * getTravelTime());
        return (double) Math.round(x * 100) / 100;
    }
    public void roundFare(double x){
        String fare = String.valueOf(x);
        if(fare.length() > 5) {
            if (fare.charAt(1) == '.') {
                System.out.println("Fare: €" + fare.substring(0, 4));
            } else {
                System.out.println("Fare: €" + fare.substring(0, 5));
            }
        }else{
            System.out.println("Fare: €" + CalculateFare());
        }
    }
    public void updateRating(String nameOfDriver, double rating)  {
        String taxidrivers = "src//main//Taxidrivers.csv";
        String tempFile = "src//main//TempTaxiDrivers.csv";
        String header = "RegistrationNumber,CarType,DriverName,DriverRating,Tier,Ratings";
        try (BufferedReader br = new BufferedReader(new FileReader(taxidrivers));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            bw.write(header + "\n");
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[2];
                double driverRating = Double.parseDouble(fields[3]);
                int ratings = Integer.parseInt(fields[5]);
                if(name.equals(nameOfDriver)){
                    ratings++;
                    double result = (rating + driverRating) / ratings;
                    driverRating = (double) Math.round(result * 100) / 100;
                }
                String updatedLine = String.join(",", fields[0], fields[1],
                        fields[2], String.valueOf(driverRating), fields[4], String.valueOf(ratings));
                bw.write(updatedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error updating rating");
        }
        File originalFile = new File(taxidrivers);
        File tempFileObj = new File(tempFile);
        try {
            java.nio.file.Files.move(tempFileObj.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Driver Rating Updated.");
        } catch (IOException e) {
            System.out.println("Error adding file.");
        }
        try (PrintWriter pw = new PrintWriter(tempFileObj)) {
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error making file blank");
        }
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

    public double getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(double driverRating) {
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
        TaxiDriver.travelTime = travelTime;
    }
}