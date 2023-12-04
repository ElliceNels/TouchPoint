import java.util.ArrayList;
import java.util.List;

public class TaxiPremium extends Taxi{
    public TaxiPremium(String registrationNumber, String carType, String driverName, int driverRating) {
        super(registrationNumber, carType, 1, driverName, driverRating);
    }

    public static List<Taxi> getTaxiDriver() {
        List<Taxi> t = new ArrayList<>();
        TaxiReg Prem1 = new TaxiReg("L 6UV 7WX", "Jaguar XJ", "Armani", 5);
        TaxiReg Prem2 = new TaxiReg("G 8YZ 9IJ", "BMW 7 Series", "Hugh", 4);
        TaxiReg Prem3 = new TaxiReg("O 6IJ 7KL", "Porsche Panamera", "Catrina", 4);
        t.add(Prem1);
        t.add(Prem2);
        t.add(Prem3);
        System.out.println(t);
        return t;
    }
}
