public class Location {
    int x;
    int y;
    static final private char displayOffice = 'O';//set as empty to read building type
    static final private char displayHouse = 'H';//displays houses as H
    static final private char displayRoad = '*';//displays roads as *
    static final private char displaySea = '/';//displays seas as ~
    static final private char displayPOI = '$';//displays point of interest as $
    static final private char displayNoRoad = '.';//road is not empty as it is always inputted last
    static final char displayPassenger = '&';
    static final private char displayPassengerDestination = '@';
    static final private char displayTaxi = '!';
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
    static ListSingleton singleton = ListSingleton.getInstance();
    //boolean[]presentLocation  = singleton.getPresentLocations();

    int getFCost() {
        return gCost + hCost;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        //presentLocations = presentLocation;
    }

    public Location(Location loc) {
        this.x = loc.x;
        this.y = loc.y;
    }

    public Location(int x, int y, boolean[]presentLocations) {
        this.x = x;
        this.y = y;
        this.presentLocations = presentLocations;
    }

    public Location(Location loc, boolean[]presentLocations) {
        this.x = loc.x;
        this.y = loc.y;
        this.presentLocations = presentLocations;
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

    public static char getDisplayOffice() {
        return displayOffice;
    }


    public static char getDisplayHouse() {
        return displayHouse;
    }


    public static char getDisplayRoad() {
        return displayRoad;
    }

    public static char getDisplaySea() {
        return displaySea;
    }


    public static char getDisplayPOI() {
        return displayPOI;
    }

    public static char getDisplayPassenger() {
        return displayPassenger;
    }


    public static char getDisplayTaxi() {
        return displayTaxi;
    }


    public static char getDisplayNoRoad() {
        return displayNoRoad;
    }


    public static char getDisplayPassengerDestination() {
        return displayPassengerDestination;
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
}



