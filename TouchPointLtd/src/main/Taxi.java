import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private String registrationNumber;//individual registration number
    private String carType;//name of taxi type
    private int capacity;//diff capacity depending on type of taxi
    private int driverRating;
    private String driverName;
    public Taxi(String registrationNumber, String carType, int capacity, String driverName, int driverRating) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.capacity = capacity;
        this.driverName = driverName;
        this.driverRating = driverRating;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}