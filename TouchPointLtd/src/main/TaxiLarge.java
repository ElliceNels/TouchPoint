import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaxiLarge extends Taxi {
    public TaxiLarge(String registrationNumber, String carType, String driverName, int driverRating) {
        super(registrationNumber, carType, 6, driverName, driverRating);
    }
    public static List<Taxi> getTaxiDriver() {
        List<Taxi> t = new ArrayList<>();
        TaxiReg Large1 = new TaxiReg("L 0QR 1ST", "Honda Pilot", "Benjamin", 2);
        TaxiReg Large2 = new TaxiReg("L 8MN 9OP", "Toyota Highlander", "Ark", 4);
        TaxiReg Large3 = new TaxiReg("L 2HI 3JK", "Ford Explorer", "Fabio", 3);
        TaxiReg Large4 = new TaxiReg("C 7PO 8DE", "Mazda CX-9", "Reece", 1);
        TaxiReg Large5 = new TaxiReg("L 5KL 6CD", "Subaru Ascent", "Pam", 5);
        TaxiReg Large6 = new TaxiReg("L 2XY 4AB", "Kia Telluride", "Pablo", 2);
        TaxiReg Large7 = new TaxiReg("L 4QR 5ST", "Volkswagen Atlas", "Panasonic", 5);
        t.add(Large1);
        t.add(Large2);
        t.add(Large3);
        t.add(Large4);
        t.add(Large5);
        t.add(Large6);
        t.add(Large7);
        System.out.println(t);
        return t;

    }
}