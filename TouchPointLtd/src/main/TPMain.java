public class TPMain {
    public static void main(String[] args) {
        TaxiReg taxiReg = new TaxiReg();
        TaxiLarge taxiLarge = new TaxiLarge();
        TaxiPremium taxiPremium = new TaxiPremium();

//        taxiReg.Test(0, 9);//These tests were to see if the values were split right
//        and the indexes for the different types of vehicles
//        taxiLarge.Test(10, 16);
//        taxiPremium.Test(17, 19);
    }
    public static int Function(int a, int b){
        return a + b;
    }
}