import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TPMain{
    public static void main(String[] args) {
       run();
    }
    public static void run(){
        Map map = new Map(20, 20); //length and width of the map
        ListSingleton singleton = ListSingleton.getInstance();
        User passenger = singleton.getPassenger();
        List<Taxi> allTaxis = singleton.getList();
        singleton.storeTaxiDetails(allTaxis);
        map.Display(passenger);
        //allows list of taxis to be accessed from singleton
        ((Passenger) passenger).mainMenuRun(passenger, map);

        map.Display(passenger);


        AStarAlgorithm.roadMapCoordinates(map);
        AStarAlgorithm.printEntireGrid();
        Taxi.moveTaxi(map);

    }

}