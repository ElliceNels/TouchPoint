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
<<<<<<< HEAD
        ((Passenger) passenger).mainMenuRun(passenger);
        map.Display(passenger);


        //allows list of taxis to be accessed from singleton
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        singleton.storeTaxiDetails(allTaxis);

=======
//        List<Taxi> allTaxis = new ArrayList<>();
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
>>>>>>> 4a8292cc41e8a92593906bd7f95a91643c6d2c5e
    }
}