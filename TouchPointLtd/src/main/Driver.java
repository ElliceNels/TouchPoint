public class Driver {
    private String name; //name of taxi driver
    private Location currentLocation;
    private int rating;
    public Driver(String name, Location currentLocation, int rating){
        this.name = name;
        this.currentLocation = currentLocation;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
