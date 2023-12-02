import java.util.ArrayList;
import java.util.List;

public class TaxiReg extends Taxi{
    public TaxiReg(String registrationNumber, String carType) {
        super(registrationNumber, carType, 4);
    }

    public static List<Taxi> getTaxiDriver() {
        List<Taxi> t = new ArrayList<>();
        TaxiReg Reg1 = new TaxiReg("L 6PQ 7RS", "Ford Explorer");
        TaxiReg Reg2 = new TaxiReg("W 4LM 5NO", "Toyota Prius");
        TaxiReg Reg3 = new TaxiReg("L 8TU 9VW", "Chevrolet Malibu");
        TaxiReg Reg4 = new TaxiReg("R 0XY 1ZA", "Hyundai Tucson");
        TaxiReg Reg5 = new TaxiReg("L 2BC 3DE", "Nissan Rogue");
        TaxiReg Reg6 = new TaxiReg("D 2AB 3EF", "Honda Civic");
        TaxiReg Reg7 = new TaxiReg("L 9MN 1GH", "Mazda CX-5");
        TaxiReg Reg8 = new TaxiReg("L 0CD 1EF", "Volvo S60");
        TaxiReg Reg9 = new TaxiReg("L 4FG 5HI", "Nissan Ultima");
        TaxiReg Reg10 = new TaxiReg("M 2UV 3WX", "Hyundai Sonata");
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
