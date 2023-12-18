import junit.framework.TestCase;
import java.util.List;

public class TPMainTest extends TestCase implements VehicleHiringTest {
    ListSingleton singleton = ListSingleton.getInstance();
    @Override
    public Location testGetVehicleLoc(String reg) {
        Map map = new Map(20, 20);
<<<<<<< HEAD
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        map.getTaxiDrivers();
        for (Taxi taxi : allTaxis) {
            System.out.println(taxi.getRegistrationNumber());
=======
        List<TaxiDriver> allTaxis = singleton.getList();
        singleton.storeTaxiDetails(allTaxis);
        map.storeMapLocations();
        map.getTaxiDrivers(map.mapLocations.get(10));
        for (TaxiDriver taxi : allTaxis) {
>>>>>>> Map-Reimplementation
            if (taxi.getRegistrationNumber().equals(reg)) {
                System.out.println(taxi.getDriverName() + " is at: " + TaxiDriver.getTaxiLoc().getX()
                        + "," + TaxiDriver.getTaxiLoc().getY());
                return TaxiDriver.getTaxiLoc();
            }else{
                System.out.println("Invalid Registration Number");
            }
        }return null;
    }
<<<<<<< HEAD
//DO THE EXACT SAME THING FOR DESTINATION
=======
>>>>>>> Map-Reimplementation
    @Override
    public boolean testMoveVehicle(String reg, Location loc) {
        Map map = new Map(20, 20);
        List<TaxiDriver> allTaxis = singleton.getList();
        singleton.storeTaxiDetails(allTaxis);
        map.storeMapLocations();
        map.getTaxiDrivers(map.mapLocations.get(10));
        for (TaxiDriver taxi : allTaxis) {
            if (taxi.getRegistrationNumber().equals(reg)) {
                System.out.println(taxi.getDriverName() + " is at " + TaxiDriver.getTaxiLoc().getX()
                        + "," + TaxiDriver.getTaxiLoc().getY());
                TaxiDriver.setTaxiLoc(loc);
                System.out.println(taxi.getDriverName() + " is now at " + TaxiDriver.getTaxiLoc().getX()
                        + "," + TaxiDriver.getTaxiLoc().getY());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TaxiDriver> testGetVehiclesInRange(Location loc, int r) {
        Map map = new Map(20, 20);
<<<<<<< HEAD
        map.getTaxiDrivers();
        ListSingleton singleton = ListSingleton.getInstance();
        List<Taxi> allTaxis = singleton.getList();
        map.Display(singleton.getPassenger());
        for (int i = loc.getX() - r; i <= loc.getX() + r; i++) {
            for (int j = loc.getY() - r; j <= loc.getY() + r; j++) {
                if (i >= 0 && i < 20 && j >= 0 && j < 20) { // Ensure the indices are within bounds
                    Location taxiLocations = map.getGrid()[i][j];
                    for (Taxi taxi : allTaxis) {
                        if (taxiLocations == taxi.getTaxiLoc() && taxiLocations.getDisplayTaxi() == '!') {
                            System.out.println("Taxi found at " + taxi.toString());
                            System.out.println(taxi.getRegistrationNumber());
                        }
                    }
                }
            }
        }return null;
=======
        map.getTaxiDrivers(loc);
        return null;
>>>>>>> Map-Reimplementation
    }

    @Override
    public boolean testRemoveVehicle(String reg) {
        Map map = new Map(20, 20);
        List<TaxiDriver> allTaxis = singleton.getList();
        singleton.storeTaxiDetails(allTaxis);
        map.storeMapLocations();
        map.getTaxiDrivers(map.mapLocations.get(10));
        for(TaxiDriver taxi : allTaxis){
            if(taxi.getRegistrationNumber().equals(reg)){
                System.out.println(taxi.getDriverName() + " is at: " + TaxiDriver.getTaxiLoc().getX()
                        + "," + TaxiDriver.getTaxiLoc().getY());
                TaxiDriver.setTaxiLoc(null);
                if(TaxiDriver.getTaxiLoc() == null){
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
        List<TaxiDriver> allTaxis = singleton.getList();
        singleton.storeTaxiDetails(allTaxis);
        map.storeMapLocations();
        map.getTaxiDrivers(map.mapLocations.get(10));
        for(TaxiDriver taxi : allTaxis){
            if(taxi.getRegistrationNumber().equals(reg)){
                System.out.println("Taxi already exists");
                return false;
            }else{
<<<<<<< HEAD
                Taxi taxiNew = new TaxiPremium(reg, "La Ferrari",  "Tiago",
=======
                TaxiDriver taxiNew = new TaxiPremium(reg, "La Ferrari", "Tiago",
>>>>>>> Map-Reimplementation
                        5, "Premium", loc);
                allTaxis.add(taxiNew);
                System.out.println(taxiNew.getDriverName() + " has been added to the map at: " + TaxiDriver.getTaxiLoc().getX()
                        + "," + TaxiDriver.getTaxiLoc().getY());
                if(TaxiDriver.getTaxiLoc() != null){
                    return true;
                }
            }
        }
        return false;
    }


    public void testReg() {
<<<<<<< HEAD
        assertNull(testGetVehicleLoc("R 0XY 1ZA"));
//        assertNull(testGetVehicleLoc("C 2QV 8DW"));
=======
        assertNotNull(testGetVehicleLoc("L 6PQ 7RS"));
>>>>>>> Map-Reimplementation
    }

    public void testMove() {
        Location location = new Location(6, 7);
        assertTrue(testMoveVehicle("L 4FG 5HI", location));
    }

    public void testRange() {
        Location location = new Location(14, 12);
        assertNull(testGetVehiclesInRange(location, 4));
    }

    public void testRemove() {
        assertTrue(testRemoveVehicle("W 4LM 5NO"));
    }

    public void testAdd() {
        Location location = new Location(2, 3);
        assertTrue(testAddToMap("C M1M H8P", location));
    }
}