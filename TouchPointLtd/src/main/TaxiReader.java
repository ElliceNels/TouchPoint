//should probably be renamed
public class TaxiReader {
    public static TaxiDriver instanceTaxi(String registrationNumber, String carType, String driverName, double driverRating, String tier, Location taxiLoc) {
        switch (tier) {
            case "Regular":
                TaxiReg taxi = new TaxiReg(registrationNumber, carType, driverName, driverRating, tier, taxiLoc);
                setTaxi(taxi , registrationNumber, carType, driverName, driverRating, tier);
                return taxi;
            case "Large":
                TaxiLarge taxi1 = new TaxiLarge(registrationNumber, carType, driverName, driverRating, tier, taxiLoc);
                setTaxi(taxi1 , registrationNumber, carType, driverName, driverRating, tier);
                return taxi1;

            case "Premium":
                TaxiPremium taxi2 = new TaxiPremium(registrationNumber, carType, driverName, driverRating, tier, taxiLoc);
                setTaxi(taxi2 , registrationNumber, carType, driverName, driverRating, tier);
                return taxi2;

            default:
                System.out.println("POORRR");
                return null;
        }
    }
    public static void setTaxi(TaxiDriver newTaxi , String registrationNumber, String carType, String driverName, double driverRating, String tier){
        newTaxi.setRegistrationNumber(registrationNumber);
        newTaxi.setCarType(carType);
        newTaxi.setDriverName(driverName);
        newTaxi.setDriverRating(driverRating);
        newTaxi.setTier(tier);
    }
}