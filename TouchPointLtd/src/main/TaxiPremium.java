public class TaxiPremium extends Taxi {
    public TaxiPremium(String registrationNumber, String carType, String driverName, int driverRating, String tier) {
        super(registrationNumber, carType, 1, driverName, driverRating, tier);
    }
    public void createTaxPremium(){
        //getTaxiDriver();
        /*if(getTier().equals("Premium")){
            getAllTaxis().add(new TaxiReg(getRegistrationNumber(), getCarType(), getDriverName(), getDriverRating(), getTier()));
        }*/
    }
}