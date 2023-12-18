
 public class TPMain{
    public static void main(String[] args) {

        run();
        //Map map = new Map(20, 20); //length and width of the map
        //ListSingleton singleton = ListSingleton.getInstance();
        //User passenger = singleton.getPassenger();
        //map.addLocationsToMap(passenger);
    }
    public static void run() {
        Map map = new Map(20, 20); //length and width of the map
        ListSingleton singleton = ListSingleton.getInstance();//calling instance of singleton
        User passenger = singleton.getPassenger();
        map.MapSet(passenger);
        ((Passenger) passenger).mainMenuRun(passenger, map);        //allows list of taxis to be accessed from singleton
        map.DisplayTaxis(passenger);
        singleton.chooseTaxi().taxiSequence((Passenger) passenger, map);
        map.MapSet(passenger);
    }
}