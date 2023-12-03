public class Location {
    int x;
    int y;
    private char displayOffice = ' ';//set as empty to read building type
    private char displayHouse = ' ';//displays houses as H
    static final char displayRoad = '*';//road is not empty as it is always inputted last
    final char displayPassenger = ' ';
    final char displayTaxi = ' ';

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

    public char getRoad() {
        return displayRoad;
    }


    public char getDisplayPassenger() {
        return displayPassenger;
    }


    public char getDisplayTaxi() {
        return displayTaxi;
    }


}


