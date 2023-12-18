import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListSingleton {
    Scanner in = new Scanner(System.in);
    private static final ListSingleton INSTANCE = new ListSingleton();

    private User passenger;

    //masterlist
    private List<TaxiDriver> allTaxis;

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
    public TaxiDriver chooseTaxi() {
        List<TaxiDriver> taxisInProx = Location.getTaxisInProximity();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Name of preferred Driver:");
            String driverName = in.nextLine().toLowerCase();

            for (int i = 0; i < taxisInProx.size(); i++) {
                if (driverName.equals(taxisInProx.get(i).getDriverName().toLowerCase())) {
                    return taxisInProx.get(i);  // Return the chosen taxi if the name matches
                }
            }

            System.out.println("Invalid Driver Name. Please try again.");
        }
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
                double driverRating = Double.parseDouble(fields[3]);
                String tier = fields[4];

                TaxiDriver taxi = TaxiReader.instanceTaxi(registrationNumber, carType, driverName, (int) driverRating, tier, TaxiDriver.getTaxiLoc());
                allTaxis.add(taxi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public User getPassenger() {
        return passenger;
    }
    public void updateRating(int x, String nameDriver, String nameInput){
        String taxiList = "src//main//Taxidrivers.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(taxiList))) {

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                double driverRating = Double.parseDouble(fields[3]);
                if (nameDriver.equals(nameInput)) {
                    driverRating = ((driverRating + x) / 2);


                }
            }
        }
             catch (IOException e) {
                 System.out.println("Error getting Rating");
            }
        }
    }

