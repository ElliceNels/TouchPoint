public class Location {
    int x;
    int y;
    private char displayOffice;//set as empty to read building type
    private char displayHouse;//displays houses as H
    private char displayRoad;//displays roads as *
    private char displaySea;//displays seas as ~
    private char displayPOI;//displays point of interest as $
    static final char displayNoRoad = '.';//road is not empty as it is always inputted last
    static char displayPassenger;
    private char displayPassengerDestination;
    private char displayTaxi;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location(Location loc) {
        this.x = loc.x;
        this.y = loc.y;
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

    public char getNoRoad() {
        return displayNoRoad;
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

    public char getDisplayPassengerDestination() {
        return displayPassengerDestination;
    }

    public void setDisplayPassengerDestination() {
        displayPassengerDestination = '@';
    }
}


