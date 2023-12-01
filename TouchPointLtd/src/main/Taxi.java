import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Taxi {
        public List<TaxiDrivers> getDrivers(){
            List<TaxiDrivers> taxiDrivers = new ArrayList<>();
            String taxiList = "src//main//TaxiDriver.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(taxiList))){
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] fields = line.split(",");
                String type = fields[0];
                String name = fields[1];
                String registrationNumber = fields[2];
                String carType = fields[3];
                int capacity = Integer.parseInt(fields[4]);
                //taxiDrivers.add(new TaxiDrivers(type, name, registrationNumber, carType, capacity));
            }
        }
            catch(IOException e){
            e.printStackTrace();
        }
        return taxiDrivers;
        }
    public static class TaxiDrivers {
        private String type;//regular, large or premium
        private String registrationNumber;//individual registration number
        private String carType;//name of taxi type
        private int capacity;//diff capacity depending on type of taxi

       /* public TaxiDrivers(String type, String name, String registrationNumber, String carType, int capacity) {
            this.type = type;
            this.name = name;
            this.registrationNumber = registrationNumber;
            this.carType = carType;
            this.capacity = capacity;
        }*/

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public void setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    }

}