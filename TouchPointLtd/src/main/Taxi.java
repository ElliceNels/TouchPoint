public class Taxi {
    private String name;//name of taxi driver
    private float registrationNumber;//individual registration number
    private int capacity;//diff capacity depending on type of taxi

    public Taxi(String name, float registrationNumber, int capacity) {
        this.name = name;//constructors
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(float registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public static double getPrice(){//method to calculate price. factors are taxi type, distance and {reviews}{reviews doesn't have to be a system}
        return 0;
    }
}
