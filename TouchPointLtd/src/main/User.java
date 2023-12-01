public abstract class User {
    private String username;
    private Location currentLocation;
    private Location destination;



    public void Login() {//User does one time login.No need to store user info as no database is needed.
        // This handles user login, calling a taxi and inputting designated area

    }
    public void getTaxi(){//once used,all taxis in a cube around user is listed

    }
    public void giveReview(){//{reviews is still an optional system}

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}
