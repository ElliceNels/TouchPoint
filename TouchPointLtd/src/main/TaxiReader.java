import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

//should probably be renamed
public class TaxiReader {

    //ListSingleton singleton = ListSingleton.getInstance();
    //<Taxi> allTaxis = singleton.getList();

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