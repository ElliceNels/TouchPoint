import java.util.List;

public interface VehicleHiringTest {
    public abstract Location testGetVehicleLoc(String reg);
    public abstract boolean testMoveVehicle(String reg, Location loc);
    public abstract List<Taxi> testGetVehiclesInRange(Location loc, int r);
}