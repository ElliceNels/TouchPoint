import junit.framework.TestCase;
import java.util.List;

public class TPMainTest extends TestCase implements VehicleHiringTest {
    ListSingleton singleton = ListSingleton.getInstance();
    @Override
    public Location testGetVehicleLoc(String reg) {
        Map map = new Map(20, 20);
        List<TaxiDriver> allTaxis = singleton.getList();
        singleton.storeTaxiDetails(allTaxis);
        map.storeMapLocations();
        map.getTaxiDrivers(map.mapLocations.get(10));
        for (TaxiDriver taxi : allTaxis) {
            if (taxi.getRegistrationNumber().equals(reg)) {
                System.out.println(taxi.getDriverName() + " is at: " + TaxiDriver.getTaxiLoc().getX()
                        + "," + TaxiDriver.getTaxiLoc().getY());
                return TaxiDriver.getTaxiLoc();
            }else{
                System.out.println("Invalid Registration Number");
            }
        }return null;
    }
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
        map.getTaxiDrivers(loc);
        return null;
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
                TaxiDriver taxiNew = new TaxiPremium(reg, "La Ferrari", "Tiago",
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
        assertNotNull(testGetVehicleLoc("L 6PQ 7RS"));
    }

    public void testMove() {
        Location location = new Location(6, 7);
        assertTrue(testMoveVehicle("L 4FG 5HI", location));
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