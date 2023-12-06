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

                Taxi taxi = TaxiReader.createTaxi(registrationNumber, carType, driverName, driverRating, tier);
                allTaxis.add(taxi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allTaxis;
    }
    public static Taxi createTaxi(String registrationNumber, String carType, String driverName, int driverRating, String tier) {
        switch (tier) {
            case "Regular":
                TaxiReg tax = new TaxiReg(registrationNumber, carType, driverName, driverRating, tier);
                tax.setRegistrationNumber(registrationNumber);
                tax.setCarType(carType);
                tax.setDriverName(driverName);
                tax.setDriverRating(driverRating);
                tax.setTier(tier);
                return tax;
            case "Large":
                TaxiLarge tax1 = new TaxiLarge(registrationNumber, carType, driverName, driverRating, tier);
                tax1.setRegistrationNumber(registrationNumber);
                tax1.setCarType(carType);
                tax1.setDriverName(driverName);
                tax1.setDriverRating(driverRating);
                tax1.setTier(tier);
                return tax1;
            case "Premium":
                TaxiPremium tax2 = new TaxiPremium(registrationNumber, carType, driverName, driverRating, tier);
                tax2.setRegistrationNumber(registrationNumber);
                tax2.setCarType(carType);
                tax2.setDriverName(driverName);
                tax2.setDriverRating(driverRating);
                tax2.setTier(tier);
                return tax2;
            default:
                System.out.println("POORRR");
                return null;
        }
    }
}