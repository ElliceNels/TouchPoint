import java.util.List;

public class TPMain{
    public static void main(String[] args) throws InterruptedException {
       run();
    }
    public static void run() throws InterruptedException {
        Map map = new Map(20, 20); //length and width of the map

        ListSingleton singleton = ListSingleton.getInstance();//calling instance of singleton
        List<TaxiDriver> allTaxis = singleton.getList();
        User passenger = singleton.getPassenger();
        map.Display(passenger);
        ((Passenger) passenger).mainMenuRun(passenger, map);        //allows list of taxis to be accessed from singleton
        map.DisplayTaxis(passenger);
        Thread.sleep(3000);
        singleton.chooseTaxi(1).taxiSequence(allTaxis, 1, (Passenger) passenger, map);

    }

}