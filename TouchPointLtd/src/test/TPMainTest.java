import junit.framework.TestCase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TPMainTest extends TestCase implements VehicleHiringTest {
    @Override
    public Location testGetVehicleLoc(String reg) {
        Map map = new Map(20, 20);
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        map.getTaxiDrivers();
        for (Taxi taxi : allTaxis) {
            if (taxi.getRegistrationNumber().equals(reg)) {
                System.out.println(taxi.getDriverName() + " is at: " + taxi);
                return taxi.getTaxiLoc();
            }else{
                System.out.println("Invalid Registration Number");
                return null;
            }
        }return null;
    }
//DO THE EXACT SAME TINGG FOR DESTINATIOJN
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
        map.getTaxiDrivers();
        ListSingleton singleton = ListSingleton.getInstance();
        map.Display(singleton.getPassenger());
        for (int i = loc.getX() - r; i <= loc.getX() + r; i++) {
            for (int j = loc.getY() - r; j <= loc.getY() + r; j++) {
                if (i >= 0 && i < 20 && j >= 0 && j < 20) { // Ensure the indices are within bounds
                    Location taxiLocations = map.getGrid()[i][j];
                    // Check if the symbol at the current location is a taxi symbol
                    if (taxiLocations != null && taxiLocations.getDisplayTaxi() == '!') {
                        System.out.println("Taxi found at (" + i + ", " + j + ")");
                    }
                }
            }
        }return null;
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
                    return true;
                }
            }
        }
        return  false;
    }

    @Override
    public boolean testAddToMap(String reg, Location loc) {
        Map map = new Map(20, 20);
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        map.Display(singleton.getPassenger());
        for(Taxi taxi : allTaxis){
            if(taxi.getRegistrationNumber().equals(reg)){
                System.out.println("Taxi already exists");
                return false;
            }else{
                Taxi taxiNew = new Taxi(reg, "La Ferrari", 1, "Tiago",
                        5, "Premium", loc);
                allTaxis.add(taxiNew);
                System.out.println(taxiNew.getDriverName() + " has been added to the map at: " + taxiNew.toString());
                if(taxi.getTaxiLoc() != null){
                    return true;
                }
            }
        }
        return false;
    }


    public void testReg() {
        assertNotNull(testGetVehicleLoc("M 2UV 3WX"));
//        assertNull(testGetVehicleLoc("C 2QV 8DW"));
    }

    public void testMove() {
        Location location = new Location(6, 7);
        assertTrue(testMoveVehicle("L 4FG 5HI", location));
        assertFalse(testMoveVehicle("L 4eG 5HI", location));
    }

    public void testRange() {
        Location location = new Location(14, 12);
        assertNull(testGetVehiclesInRange(location, 2));
    }

    public void testRemove() {
        assertTrue(testRemoveVehicle("W 4LM 5NO"));
    }

    public void testAdd() {
        Location location = new Location(2, 3);
        assertTrue(testAddToMap("C M1M H8P", location));
    }
}