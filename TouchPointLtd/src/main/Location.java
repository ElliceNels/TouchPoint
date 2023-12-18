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

    private static List<TaxiDriver> taxisInProximity;

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

}


