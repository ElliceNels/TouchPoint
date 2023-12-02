public class Location {
    int x;
    int y;
    private char displayBuildings;//added to display buildings on map

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

    public char getDisplayBuildings() {
        return displayBuildings;
    }

    public void setDisplayBuildings(char displayBuildings) {
        this.displayBuildings = displayBuildings;
    }
}

