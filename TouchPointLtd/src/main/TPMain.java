import java.util.List;

public class TPMain{
    public static void main(String[] args) {
       run();
    }
    public static void run(){
        Map map = new Map(20, 20); //length and width of the map

        //printEntireGrid();
        AStarAlgorithm.roadMapCoordinates(map);
        List<Location> path = AStarAlgorithm.findPath();
        TaxiDriver.setTravelTime(0);
        //ensures there is an actual path
        if (path != null) {
            for (Location location : path) {
                System.out.println("(" + location.x + ", " + location.y + ")");
                //TaxiDriver.setTravelTime(TaxiDriver.getTravelTime()++);
            }
        } else {
            System.out.println("Your location cannot be accessed by taxi.");
        }
        ListSingleton singleton = ListSingleton.getInstance();
        User passenger = singleton.getPassenger();
        map.Display(passenger);
        //allows list of taxis to be accessed from singleton
        ((Passenger) passenger).mainMenuRun(passenger, map);
        map.getTaxiDrivers(passenger);
        map.Display(passenger);
    }

}