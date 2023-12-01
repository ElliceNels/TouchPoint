public class Driver {
    private String name; //name of taxi driver
    private Location currentLocation;

    public Driver(String name, Location currentLocation){
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
