import java.util.List;

public class TaxiReg extends Taxi {
    public TaxiReg(String registrationNumber, String carType, String driverName, int driverRating, String tier) {
        super(registrationNumber, carType, 4, driverName, driverRating, tier);
    }
    /*public void createTaxiReg(){
        getTaxiDriver();
        if(getTier().equals("Regular")){
            getAllTaxis().add(new TaxiReg(getRegistrationNumber(), getCarType(), getDriverName(), getDriverRating(), getTier()));
        }
    }*/



}