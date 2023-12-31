import java.io.IOException;

public class TPMain{
    public static void main(String[] args) throws IOException, InterruptedException {
        this.getClass().getCanonicalName();
        run();
    }
    public static void run() throws IOException, InterruptedException {
        Map map = new Map(20, 20); //length and width of the map
        ListSingleton singleton = ListSingleton.getInstance();//calling instance of singleton
        User passenger = singleton.getPassenger();
        map.MapSet(passenger);
        ((Passenger) passenger).mainMenuRun(passenger, map);
        map.DisplayTaxis(passenger);
        System.out.println("Taxi drivers listed above");
        singleton.chooseTaxi().taxiSequence((Passenger) passenger, map);
    }
}