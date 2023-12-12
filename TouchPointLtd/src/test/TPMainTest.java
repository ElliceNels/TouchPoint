import junit.framework.TestCase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TPMainTest extends TestCase implements VehicleHiringTest {
    @Override
    public Location testGetVehicleLoc(String reg) {
        Map map = new Map(20, 20);
        map.getTaxiDrivers();
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        for (Taxi taxi : allTaxis) {
            if (taxi.getRegistrationNumber().equals(reg)) {
                System.out.println(taxi);
                return taxi.getTaxiLoc();
            }
        }return null;
    }

    @Override
    public boolean testMoveVehicle(String reg, Location loc) {
        Map map = new Map(20, 20);
        map.getTaxiDrivers();
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        for (Taxi taxi : allTaxis) {
            if (taxi.getRegistrationNumber().equals(reg)) {
                System.out.println(taxi.getDriverName() + " is at " + taxi.toString());
                taxi.setTaxiLoc(loc);
                System.out.println(taxi.getDriverName() + " is now at " + taxi.toString());
                return true;
            }
        }
        System.out.println("Taxi is not registered or added to map");
        return false;
    }

    @Override
    public List<Taxi> testGetVehiclesInRange(Location loc, int r) {
        Map map = new Map(20, 20);
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        singleton.storeTaxiDetails(allTaxis);
        List<Taxi> taxisInRange = new ArrayList<>();
        map.Display(singleton.getPassenger());
        int count = 0;

        for (Taxi taxi : allTaxis) {
            Location taxiLocation = taxi.getTaxiLoc();
            // Check if the taxi is within the specified range
            if (Math.abs(taxiLocation.getX() - loc.getX()) <= r && Math.abs(taxiLocation.getY() - loc.getY()) <= r) {
                System.out.println("Registration Number: " + taxi.getRegistrationNumber());
                count++;
                taxisInRange.add(taxi);
            }
        }

        System.out.println("Total number of taxis in area: " + count);
        return taxisInRange;
    }

    @Override
    public boolean testRemoveVehicle(String reg) {
        Map map = new Map(20, 20);
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        map.Display(singleton.getPassenger());
        for(Taxi taxi : allTaxis){
            if(taxi.getRegistrationNumber().equals(reg)){
                System.out.println(taxi.getDriverName() + " is at: " + taxi.toString());
                taxi.setTaxiLoc(null);
                if(taxi.getTaxiLoc() == null){
                    System.out.println(taxi.getDriverName() + " has been removed from the map.");
                    map.Display(singleton.getPassenger());
                    return true;
                }
            }
        }
        return  false;
    }


    @Test
    public void testReg() {
        assertNotNull(testGetVehicleLoc("L 4QR 5ST"));
    }

    @Test
    public void testMove() {
        Location location = new Location(2, 2);
        assertEquals(true, testMoveVehicle("L 4FG 5HI", location));
        assertEquals(false, testMoveVehicle("L 4FwqwdeG 5HI", location));
    }

    @Test
    public void testRange() {
        Location location = new Location(14, 12);
        assertNotNull(testGetVehiclesInRange(location, 6));
    }

    @Test
    public void testRemove() {
        assertEquals(true, testRemoveVehicle("W 4LM 5NO"));
    }
}