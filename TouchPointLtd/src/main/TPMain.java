import java.util.List;

public class TPMain{
    public static void main(String[] args) {
       run();
    }
    public static void run(){
        Map map = new Map(20, 20); //length and width of the map
        ListSingleton singleton = ListSingleton.getInstance();
        User passenger = singleton.getPassenger();
        map.Display(passenger);
        //allows list of taxis to be accessed from singleton
        ((Passenger) passenger).mainMenuRun(passenger, map);
        map.getTaxiDrivers(passenger);
        map.Display(passenger);
    }

}