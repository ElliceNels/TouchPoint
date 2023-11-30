public class Taxi {
    private String name;
    private float registrationNumber;
    private int capacity;

    public Taxi(String name, float registrationNumber, int capacity) {
        this.name = name;
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

    public void setRegistrationNumber(float regeistrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public static double getPrice(){
        return 0;
    }
}
