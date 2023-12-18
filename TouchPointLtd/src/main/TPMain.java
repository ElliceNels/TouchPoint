import java.io.IOException;

public class TPMain{
<<<<<<< HEAD
    public static void main(String[] args) throws IOException, InterruptedException {
        run();
    }
    public static void run() throws IOException, InterruptedException {
=======
    public static void main(String[] args) throws IOException {
                run();
    }

    public static void run() throws IOException {
>>>>>>> 3bca061cae240700506e501af207eafb6b1367a4
        Map map = new Map(20, 20); //length and width of the map
        ListSingleton singleton = ListSingleton.getInstance();//calling instance of singleton
        User passenger = singleton.getPassenger();
        map.MapSet(passenger);
        ((Passenger) passenger).mainMenuRun(passenger, map);        //allows list of taxis to be accessed from singleton
        map.DisplayTaxis(passenger);
        singleton.chooseTaxi().taxiSequence((Passenger) passenger, map);
        map.DisplayTaxis(passenger);
//        map.MapSet(passenger);
    }
}