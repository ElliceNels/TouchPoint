import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TPMain {
    public static void main(String[] args) {
       run();
    }
    public static int placeholder(int a, int b){
        return a + b;
    }
    public static void run(){
        Map map = new Map(20, 20); //length and width of the map

        User passenger = new Passenger();
        map.Display(passenger);
        List<Taxi> allTaxis = new ArrayList<>();
//        System.out.println(TaxiReader.getTaxiDetails(allTaxis));
//        map.Display(passenger);
//        ((Passenger) passenger).mainMenuRun(passenger);
//        map.Display(passenger);
//        User passenger = new Passenger();
//        ListSingleton singleton = ListSingleton.getInstance();
//
//        //allows list of taxis to be accessed from singleton
//        List<Taxi> allTaxis = singleton.getList();
//        singleton.storeTaxiDetails(allTaxis);
//
//        map.Display(passenger);
//        ((Passenger) passenger).mainMenuRun(passenger);
//        map.Display(passenger);
    }
}