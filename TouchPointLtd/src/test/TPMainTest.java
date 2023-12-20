import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TPMainTest extends TestCase implements VehicleHiringTest {
    ListSingleton singleton = ListSingleton.getInstance();
    @Override
    public Location testGetVehicleLoc(String reg) {
        Map map = new Map(20, 20);
        singleton.storeTaxiDetails(singleton.getList());
        map.storeMapLocations();
        map.getTaxiDrivers(map.mapLocations.get(10));
        for (int i = 0;i < singleton.getList().size();i++) {
            TaxiDriver taxiDriver = singleton.getList().get(i);
            if (taxiDriver.getRegistrationNumber().equals(reg)) {
                System.out.println(taxiDriver.getDriverName() + " is at: " + taxiDriver.getTaxiLoc().getX()
                        + "," + taxiDriver.getTaxiLoc().getY());
                return taxiDriver.getTaxiLoc();
            }else{
                System.out.println("Invalid Registration Number");
            }
        }return null;
    }
    @Override
    public boolean testMoveVehicle(String reg, Location loc) {
        Map map = new Map(20, 20);
        singleton.storeTaxiDetails(singleton.getList());
        map.storeMapLocations();
        map.getTaxiDrivers(map.mapLocations.get(10));
        for (int i = 0;i < singleton.getList().size();i++) {
            TaxiDriver taxiDriver = singleton.getList().get(i);
            if (taxiDriver.getRegistrationNumber().equals(reg)) {
                System.out.println(taxiDriver.getDriverName() + " is at " + taxiDriver.getTaxiLoc().getX()
                        + "," + taxiDriver.getTaxiLoc().getY());
                taxiDriver.setTaxiLoc(loc);
                System.out.println(taxiDriver.getDriverName() + " is now at " + taxiDriver.getTaxiLoc().getX()
                        + "," + taxiDriver.getTaxiLoc().getY());
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
        singleton.storeTaxiDetails(singleton.getList());
        map.storeMapLocations();
        map.getTaxiDrivers(map.mapLocations.get(10));
        for (int i = 0;i < singleton.getList().size();i++) {
            TaxiDriver taxiDriver = singleton.getList().get(i);
            if(taxiDriver.getRegistrationNumber().equals(reg)){
                System.out.println(taxiDriver.getDriverName() + " is at: " + taxiDriver.getTaxiLoc().getX()
                        + "," + taxiDriver.getTaxiLoc().getY());
                taxiDriver.setTaxiLoc(null);
                if(taxiDriver.getTaxiLoc() == null){
                    System.out.println(taxiDriver.getDriverName() + " has been removed from the map.");
                    return true;
                }
            }
        }
        return  false;
    }

    @Override
    public boolean testAddToMap(String reg, Location loc) {
        Map map = new Map(20, 20);
        singleton.storeTaxiDetails(singleton.getList());
        map.storeMapLocations();
        map.getTaxiDrivers(map.mapLocations.get(10));
        for (int i = 0;i < singleton.getList().size();i++) {
            TaxiDriver taxiDriver = singleton.getList().get(i);
            if(taxiDriver.getRegistrationNumber().equals(reg)){
                taxiDriver.setTaxiLoc(loc);
                loc.setTaxiPresent(true);
                Map.setGrid(loc);
                singleton.getMap().displayMap();
                return true;
            }
        }
        System.out.println("Invalid Registration Number");
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
        assertNull(testGetVehiclesInRange(location, 4));
    }

    public void testRemove() {
        assertTrue(testRemoveVehicle("W 4LM 5NO"));
    }

    public void testAdd() {
        Location location = new Location(2, 3);
        assertTrue(testAddToMap("L 4FG 5HI", location));
    }
}