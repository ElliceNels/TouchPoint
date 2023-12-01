public class TaxiPremium extends Taxi{
    private TaxiPremium premium1;
    private TaxiPremium premium2;
    private TaxiPremium premium3;
    public TaxiPremium(String registrationNumber, String carType) {
        super(registrationNumber, carType, 3);
        this.premium1 = new TaxiPremium("O 6IJ 7KL","Porsche Panamera");
        this.premium2 = new TaxiPremium("G 8YZ 9IJ","BMW 7 Series");
        this.premium3 = new TaxiPremium("L 6UV 7WX","Jaguar XJ");
    }

    public TaxiPremium getPremium1() {
        return premium1;
    }

    public void setPremium1(TaxiPremium premium1) {
        this.premium1 = premium1;
    }

    public TaxiPremium getPremium2() {
        return premium2;
    }

    public void setPremium2(TaxiPremium premium2) {
        this.premium2 = premium2;
    }

    public TaxiPremium getPremium3() {
        return premium3;
    }

    public void setPremium3(TaxiPremium premium3) {
        this.premium3 = premium3;
    }
}
