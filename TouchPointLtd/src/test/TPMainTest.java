import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class TPMainTest extends TestCase {

    /*@Test
    public void testLogin(){
        assertEquals(true, Passenger.Login());
    }*/

    public void testPlaceholder(){
        assertEquals(5, TPMain.placeholder(3, 2));
    }
    /*public boolean testGetTaxiDrivers(String registrationNumber, Location loc) {
        List<Taxi> t = Taxi.getTaxiDriver(4);
        Random rand = new Random();
        for (int i = 0; i < t.size(); i++) {
            int startIndex = 88;
            int endIndex = 197;
            int randInt = rand.nextInt((endIndex - startIndex + 1)) + startIndex;
            System.out.println(randInt);
            int TaxiX = Map.locations[randInt][0];
            int TaxiY = Map.locations[randInt][1];
            grid[TaxiX][TaxiY] = new Location(TaxiX, TaxiY);
            grid[TaxiX][TaxiY].setDisplayTaxi();

        }
        if (grid[TaxiX][TaxiY] = getDisplayTaxi){

        }
    }

     */

}