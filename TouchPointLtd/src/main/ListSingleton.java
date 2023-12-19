import java.io.*;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListSingleton {
    Scanner in = new Scanner(System.in);
    private static final ListSingleton INSTANCE = new ListSingleton();

    private User passenger;

    //masterList
    private List<TaxiDriver> allTaxis;
    private TaxiDriver chosenTaxi;
    private Map map;


    //Creates a new arraylist with all values of the allTaxis list (for access in all classes)
    private ListSingleton() {
        // Initialize the list in the constructor
        allTaxis = new ArrayList<>();
        passenger = new Passenger();
        map = new Map(20, 20);
    }

    public static ListSingleton getInstance() {
        return INSTANCE;
    }

    public List<TaxiDriver> getList() {
        return allTaxis;
    }

    public TaxiDriver chooseTaxi() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Name of preferred Driver:");
            String driverName = in.nextLine().toLowerCase();

            for (TaxiDriver allTaxi : allTaxis) {
                if (driverName.equals(allTaxi.getDriverName().toLowerCase())) {
                    allTaxi.setTaxiLoc(allTaxi.getTaxiLoc());
                    setChosenTaxi(allTaxi);
                    return chosenTaxi;  // Return the chosen taxi if the name matches
                }
            }

            System.out.println("Invalid Driver Name. Please try again.");
        }
    }


    //Takes info from csv, turns them into drivers of their respective type and adds them to list
    public void storeTaxiDetails(List<TaxiDriver> allTaxis) {
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

                TaxiDriver taxi = TaxiReader.instanceTaxi(registrationNumber, carType, driverName, driverRating, tier, getTaxiLocation());
                allTaxis.add(taxi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public User getPassenger() {
        return passenger;
    }

    public void setChosenTaxi(TaxiDriver chosenTaxi) {
        this.chosenTaxi = chosenTaxi;
    }
    public TaxiDriver getChosenTaxi(){
        return chosenTaxi;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    public Location getTaxiLocation() {
        for (TaxiDriver taxi : allTaxis) {
            return taxi.getTaxiLoc();
        }
        return null;
    }
}

