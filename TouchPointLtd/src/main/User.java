public abstract class User {
    private String username;
    private Location currentLocation;
    private Location destination;
    private Location pickupPoint;
    private Location closestDestination;
    public void orderTaxi(){//once used,all taxis in a cube around user is listed

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

    public int getPreferredRadius() {
        return 4;
    }

    public Location getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(Location pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public Location getClosestDestination() {
        return closestDestination;
    }

    public void setClosestDestination(Location closestDestination) {
        this.closestDestination = closestDestination;
    }
}
