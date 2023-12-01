public class TPMain {
    public static void main(String[] args) {
        Location park = new Location(1, 2);
        Location home = new Location(8,9);
        Passenger passenger = new Passenger("Ellice", home, park);

        System.out.println(passenger.getUsername());
    }
}