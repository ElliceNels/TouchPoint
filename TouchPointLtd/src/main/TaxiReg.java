import java.util.ArrayList;
import java.util.List;

public class TaxiReg extends Taxi {
    private List<Taxi> allRegTaxi;

    public TaxiReg(String registrationNumber, String carType, String driverName, int driverRating, Location taxiLocation) {
        super(registrationNumber, carType, 4, driverName, driverRating, taxiLocation);

        allRegTaxi = new ArrayList<>();
        Taxi Reg1 = new TaxiReg("L 6PQ 7RS", "Ford Explorer", "John", 2, getTaxiLocation());
        Taxi Reg2 = new TaxiReg("W 4LM 5NO", "Toyota Prius", "Steven", 5, getTaxiLocation());
        Taxi Reg3 = new TaxiReg("L 8TU 9VW", "Chevrolet Malibu", "Jon", 4, getTaxiLocation());
        Taxi Reg4 = new TaxiReg("R 0XY 1ZA", "Hyundai Tucson", "Adam", 2, getTaxiLocation());
        Taxi Reg5 = new TaxiReg("L 2BC 3DE", "Nissan Rogue", "Amone", 1, getTaxiLocation());
        Taxi Reg6 = new TaxiReg("D 2AB 3EF", "Honda Civic", "Ronda", 4, getTaxiLocation());
        Taxi Reg7 = new TaxiReg("L 9MN 1GH", "Mazda CX-5", "Wilson", 3, getTaxiLocation());
        Taxi Reg8 = new TaxiReg("L 0CD 1EF", "Volvo S60", "Peter", 1, getTaxiLocation());
        Taxi Reg9 = new TaxiReg("L 4FG 5HI", "Nissan Ultima", "Ellice", 5, getTaxiLocation());
        Taxi Reg10 = new TaxiReg("M 2UV 3WX", "Hyundai Sonata", "JJ", 4, getTaxiLocation());
        Reg1.setTaxiLocation(new Location(8, 9));
        allRegTaxi.add(Reg1);
        allRegTaxi.add(Reg2);
        allRegTaxi.add(Reg3);
        allRegTaxi.add(Reg4);
        allRegTaxi.add(Reg5);
        allRegTaxi.add(Reg6);
        allRegTaxi.add(Reg7);
        allRegTaxi.add(Reg8);
        allRegTaxi.add(Reg9);
        allRegTaxi.add(Reg10);
    }

    public List<Taxi> getAllRegTaxiTaxi() {
        return allRegTaxi;
}


}
