import java.util.ArrayList;
import java.util.List;
public class Location {
    int x;
    int y;
    boolean passengerPresent;
    boolean passengerDestPresent;
    boolean taxiPresent;
    boolean roadPresent;
    boolean seaPresent;
    boolean officePresent;
    boolean housePresent;
    boolean POIPresent;
    boolean nonRoadPresent;
    private boolean[] presentLocations;
    int gCost, hCost;
    Location parent; //location
<<<<<<< HEAD
    static ListSingleton singleton = ListSingleton.getInstance();
    boolean[] presentLocation = singleton.getPresentLocations();

=======
    private static List<TaxiDriver> taxisInProximity;
>>>>>>> Map-Reimplementation
    int getFCost() {
        return gCost + hCost;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        taxisInProximity = new ArrayList<>();
    }

    public Location(Location loc) {
        this.x = loc.x;
        this.y = loc.y;
    }

    public Location(int x, int y, boolean[] presentLocations) {
        this.x = x;
        this.y = y;
        this.presentLocations = presentLocations;
    }

    public Location(Location loc, boolean[] presentLocations) {
        this.x = loc.x;
        this.y = loc.y;
        this.presentLocations = presentLocations;
    }
    public Location(Location loc, boolean[]presentLocations, List<TaxiDriver> taxisInProximity) {
        this.x = loc.x;
        this.y = loc.y;
        this.presentLocations = presentLocations;
        Location.taxisInProximity = taxisInProximity;
    }

    public boolean[] array(){
        boolean[] presentLocation = {passengerPresent, passengerDestPresent, taxiPresent, roadPresent,
                seaPresent, officePresent, housePresent, POIPresent, nonRoadPresent};
        return presentLocation;
    }



    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

<<<<<<< HEAD
    public char getDisplayOffice() {
        return displayOffice;
    }

    public void setDisplayOffice() {
        displayOffice = 'O';
    }

    public char getDisplayHouse() {
        return displayHouse;
    }

    public void setDisplayHouse() {
        displayHouse = 'H';
    }

    public char getDisplayRoad() {
        return displayRoad;
    }

    public void setDisplayRoad() {
        displayRoad = '*';
    }

    public char getDisplaySea() {
        return displaySea;
    }

    public void setDisplaySea() {
        displaySea = '/';
    }

    public char getDisplayPOI() {
        return displayPOI;
    }

    public void setDisplayPOI() {
        displayPOI = '$';
    }

    public char getDisplayPassenger() {
        return displayPassenger;
    }

    public void setDisplayPassenger() {
        displayPassenger = '&';
    }

    public char getDisplayTaxi() {
        return displayTaxi;
    }

    public void setDisplayTaxi() {
        displayTaxi = '!';
    }

    public char getDisplayNoRoad() {
        return displayNoRoad;
    }

    public void setDisplayNoRoad() {
        displayNoRoad = '.';
    }

    public char getDisplayPassengerDestination() {
        return displayPassengerDestination;
    }

    public void setDisplayPassengerDestination() {
        displayPassengerDestination = '@';
    }

=======
>>>>>>> Map-Reimplementation
    public boolean isPassengerPresent() {
        return passengerPresent;
    }

    public void setPassengerPresent(boolean passengerPresent) {
        this.passengerPresent = passengerPresent;
    }

    public boolean isPassengerDestPresent() {
        return passengerDestPresent;
    }

    public void setPassengerDestPresent(boolean passengerDestPresent) {
        this.passengerDestPresent = passengerDestPresent;
    }

    public boolean isTaxiPresent() {
        return taxiPresent;
    }

    public void setTaxiPresent(boolean taxiPresent) {
        this.taxiPresent = taxiPresent;
    }

    public boolean isRoadPresent() {
        return roadPresent;
    }

    public void setRoadPresent(boolean roadPresent) {
        this.roadPresent = roadPresent;
    }

    public boolean isSeaPresent() {
        return seaPresent;
    }

    public void setSeaPresent(boolean seaPresent) {
        this.seaPresent = seaPresent;
    }

    public boolean isOfficePresent() {
        return officePresent;
    }

    public void setOfficePresent(boolean officePresent) {
        this.officePresent = officePresent;
    }

    public boolean isHousePresent() {
        return housePresent;
    }

    public void setHousePresent(boolean housePresent) {
        this.housePresent = housePresent;
    }

    public boolean isNonRoadPresent() {
        return nonRoadPresent;
    }

    public void setNonRoadPresent(boolean nonRoadPresent) {
        this.nonRoadPresent = nonRoadPresent;
    }
<<<<<<< HEAD
=======

    public boolean isPOIPresent() {
        return POIPresent;
    }

    public void setPOIPresent(boolean POIPresent) {
        this.POIPresent = POIPresent;
    }

    public static List<TaxiDriver> getTaxisInProximity() {
        return taxisInProximity;
    }

    public void setTaxisInProximity(List<TaxiDriver> objectList) {
        Location.taxisInProximity = objectList;
    }
>>>>>>> Map-Reimplementation
}


