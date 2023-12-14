import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ListSingleton {
    private static final ListSingleton INSTANCE = new ListSingleton();

    private User passenger;
    //masterlist
    private List<TaxiDriver> allTaxis;
    private boolean[]presentLocations;

    //Creates a new arraylist with all values of the allTaxis list (for access in all classes)
    private ListSingleton() {
        // Initialize the list in the constructor
        allTaxis = new ArrayList<>();
        passenger = new Passenger();
    }

    public static ListSingleton getInstance() {
        return INSTANCE;
    }

    public List<TaxiDriver> getList() {
        return allTaxis;
    }
    //Takes info from csv, turns them into drivers of their respective type and adds them to list
    public void storeTaxiDetails(List <TaxiDriver> allTaxis) {
        String taxidrivers = "src//main//Taxidrivers.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(taxidrivers))) {
            String line;
            br.readLine();
            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                // Split the line into fields using a comma as the delimiter
                String[] fields = line.split(",");
                String registrationNumber = fields[0];
                String carType = fields[1];
                String driverName = fields[2];
                int driverRating = Integer.parseInt(fields[3]);
                String tier = fields[4];

                TaxiDriver taxi = TaxiReader.instanceTaxi(registrationNumber, carType, driverName, driverRating, tier, getTaxiLocation());
                allTaxis.add(taxi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setTaxiLocation(Location location) {
        for (TaxiDriver taxi : allTaxis) {
                taxi.setTaxiLoc(location);
            }
        }
    public Location getTaxiLocation() {
        for (TaxiDriver taxi : allTaxis) {
                return taxi.getTaxiLoc();
        }
        return null;
    }

    public User getPassenger() {
        return passenger;
    }
}

