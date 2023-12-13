public class Location {
    int x;
    int y;
    final private char displayOffice = 'O';//set as empty to read building type
    final private char displayHouse = 'H';//displays houses as H
    final private char displayRoad = '*';//displays roads as *
    final private char displaySea = '/';//displays seas as ~
    final private char displayPOI = '$';//displays point of interest as $
    final private char displayNoRoad = '.';//road is not empty as it is always inputted last
    final char displayPassenger = '&';
    final private char displayPassengerDestination = '@';
    final private char displayTaxi = '!';
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
        boolean[] presentLocation = {passengerPresent, passengerDestPresent, taxiPresent, roadPresent, seaPresent, officePresent, housePresent, POIPresent, nonRoadPresent};
        return presentLocation;
    }

    public void choosePlace() { //i is array element with location
            for (int j = 0; j < array().length; j++) {       //j is the index of the type of this is looking for
                if (array()[0]) {
                    System.out.println(displayPassenger);
                } else if (array()[1]) {
                    System.out.println(displayPassengerDestination);
                } else if (array()[2]) {
                    System.out.println(displayTaxi);
                } else if (array()[3]) {
                    System.out.println(displayRoad);
                } else if (array()[4]) {
                    System.out.println(displaySea);
                } else if (array()[5]) {
                    System.out.println(displayOffice);
                } else if (array()[6]) {
                    System.out.println(displayHouse);
                } else if (array()[7]) {
                    System.out.println(displayPOI);
                } else if (array()[8]) {
                    System.out.println(displayNoRoad);
                }
            }

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

    /*
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

    public void setDisplayPassenger(){
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


     */
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



