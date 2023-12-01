public class Taxi {
    private String registrationNumber;//individual registration number
    private String carType;//name of taxi type
    private int capacity;//diff capacity depending on type of taxi

    public Taxi(String registrationNumber, String carType, int capacity) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.capacity = capacity;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}