import java.io.IOException;

public class TPMain{
    public static void main(String[] args) throws IOException, InterruptedException {
        run();
    }
    public static void run() throws IOException, InterruptedException {

        Map map = new Map(20, 20); //length and width of the map
        ListSingleton singleton = ListSingleton.getInstance();//calling instance of singleton
//        Map map = singleton.getMap();
        User passenger = singleton.getPassenger();
        map.MapSet(passenger);
        ((Passenger) passenger).mainMenuRun(passenger, map);        //allows list of taxis to be accessed from singleton
        map.DisplayTaxis(passenger);
        singleton.chooseTaxi().taxiSequence((Passenger) passenger, map);
        map.DisplayTaxis(passenger);
        map.MapSet(passenger);
    }
}