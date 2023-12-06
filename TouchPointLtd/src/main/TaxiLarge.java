public class TaxiLarge extends Taxi {
    public TaxiLarge(String registrationNumber, String carType, String driverName, int driverRating, String tier) {
        super(registrationNumber, carType, 6, driverName, driverRating, tier);
    }
    public void createTaxiLarge(){
        /*getTaxiDriver();
        if(getTier().equals("Large")){
            getAllTaxis().add(new TaxiReg(getRegistrationNumber(), getCarType(), getDriverName(), getDriverRating(), getTier()));
        }*/
    }
}