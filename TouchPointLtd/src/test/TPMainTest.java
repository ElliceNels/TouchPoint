import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class TPMainTest extends TestCase implements VehicleHiringTest {
    @Override
    public String testGetVehicleLoc(String reg) {
        Map map = new Map(20, 20);
        map.getTaxiDrivers();
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        for (Taxi taxi : allTaxis) {
            if (taxi.getRegistrationNumber().equals(reg)) {
                return taxi.toString();
            }
        }
        return null;
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

    @Test
    public void testReg() {
        assertEquals("2,5", testGetVehicleLoc("L 2BC 3DE"));
    }

    @Test
    public void testMove() {
        Location location = new Location(12, 8);
        assertEquals(true, testMoveVehicle("L 2BC 3DE", location));
    }
}