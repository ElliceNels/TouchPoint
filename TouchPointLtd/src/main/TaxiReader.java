import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TaxiReader {
    public static List<Taxi> getTaxiDetails(List <Taxi> allTaxis) {

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

                Taxi taxi = TaxiReader.instanceTaxi(registrationNumber, carType, driverName, driverRating, tier);
                allTaxis.add(taxi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allTaxis;
    }
    public static Taxi instanceTaxi(String registrationNumber, String carType, String driverName, int driverRating, String tier) {
        switch (tier) {
            case "Regular":
                TaxiReg taxi = new TaxiReg(registrationNumber, carType, driverName, driverRating, tier);
                setTaxi(taxi , registrationNumber, carType, driverName, driverRating, tier);
                return taxi;
            case "Large":
                TaxiLarge taxi1 = new TaxiLarge(registrationNumber, carType, driverName, driverRating, tier);
                setTaxi(taxi1 , registrationNumber, carType, driverName, driverRating, tier);
                return taxi1;

            case "Premium":
                TaxiPremium taxi2 = new TaxiPremium(registrationNumber, carType, driverName, driverRating, tier);
                setTaxi(taxi2 , registrationNumber, carType, driverName, driverRating, tier);
                return taxi2;

            default:
                System.out.println("POORRR");
                return null;
        }
    }
    public static void setTaxi(Taxi newTaxi , String registrationNumber, String carType, String driverName, int driverRating, String tier){
        newTaxi.setRegistrationNumber(registrationNumber);
        newTaxi.setCarType(carType);
        newTaxi.setDriverName(driverName);
        newTaxi.setDriverRating(driverRating);
        newTaxi.setTier(tier);
    }
}