import java.util.List;

public class TPMain{
    public static void main(String[] args) {
       run();
    }
    public static void run(){
        Map map = new Map(20, 20); //length and width of the map

        ListSingleton singleton = ListSingleton.getInstance();
        List<TaxiDriver> allTaxis = singleton.getList();
        User passenger = singleton.getPassenger();
        map.Display(passenger);
        //allows list of taxis to be accessed from singleton
        ((Passenger) passenger).mainMenuRun(passenger, map);
        map.DisplayTaxis(passenger);
        singleton.chooseTaxi(1).taxiSequence((Passenger) passenger, map);
        //singleton.chooseTaxi(1).MoveToPassenger(passenger, map);
    }

}