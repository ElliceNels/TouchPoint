import java.util.ArrayList;
import java.util.List;

public class TaxiReg extends Taxi{

    public TaxiReg(String registrationNumber, String carType, String driverName, int driverRating) {
        super(registrationNumber, carType, 4, driverName, driverRating);
    }

    public List<Taxi> getTaxiDriver() {
        List<Taxi> t = new ArrayList<>();
        Taxi Reg1 = new TaxiReg("L 6PQ 7RS", "Ford Explorer", "John", 2);
        Taxi Reg2 = new TaxiReg("W 4LM 5NO", "Toyota Prius", "Steven", 5);
        Taxi Reg3 = new TaxiReg("L 8TU 9VW", "Chevrolet Malibu", "Jon", 4);
        Taxi Reg4 = new TaxiReg("R 0XY 1ZA", "Hyundai Tucson", "Adam", 2);
        Taxi Reg5 = new TaxiReg("L 2BC 3DE", "Nissan Rogue", "Amone", 1);
        Taxi Reg6 = new TaxiReg("D 2AB 3EF", "Honda Civic", "Ronda", 4);
        Taxi Reg7 = new TaxiReg("L 9MN 1GH", "Mazda CX-5", "Wilson", 3);
        Taxi Reg8 = new TaxiReg("L 0CD 1EF", "Volvo S60", "Peter", 1);
        Taxi Reg9 = new TaxiReg("L 4FG 5HI", "Nissan Ultima", "Ellice",5);
        Taxi Reg10 = new TaxiReg("M 2UV 3WX", "Hyundai Sonata", "JJ", 4);
        t.add(Reg1);
        t.add(Reg2);
        t.add(Reg3);
        t.add(Reg4);
        t.add(Reg5);
        t.add(Reg6);
        t.add(Reg7);
        t.add(Reg8);
        t.add(Reg9);
        t.add(Reg10);
        System.out.println(t);
        return t;
    }
}
