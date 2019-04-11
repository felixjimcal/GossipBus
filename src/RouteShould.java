import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

public class RouteShould {

    BusDriver driverA, driverB, driverC, driverD, driverE, driverF, driverG;

    Route route_BCN;


    @Before
    public void Initialize()
    {
        driverA = new BusDriver('A', 7,11,2,2,4,8,2,2);
        driverB = new BusDriver('B', 3,0,11,8);
        driverC = new BusDriver('C', 5,11,8,10,3,11);
        driverD = new BusDriver('D', 5,9,2,5,0,3);
        driverE = new BusDriver('E', 7,4,8,2,8,1,0,5);
        driverF = new BusDriver('F', 3,6,8,9);
        driverG = new BusDriver('G', 4,2,11,3,3);

        route_BCN = new Route(driverA, driverB, driverC, driverD, driverE, driverF, driverG);
    }

    @Test
    public void CheckAllTheGossips()
    {
        Set<Character> expected_stops = route_BCN.m_all_the_gossips;
        Assert.assertThat(expected_stops, is(new HashSet(Arrays.asList('A','B','C','D','E','F','G'))));
    }

    @Test
    public void CheckActualRepeatedStops()
    {
        Set<Integer> expected_stops = route_BCN.m_actual_repeated_stops;
        Assert.assertThat(expected_stops, is(new HashSet(Arrays.asList(7,5,3))));
    }

    @Test
    public void CheckDriversOnTheStop3()
    {
        List<BusDriver> expected_drivers = route_BCN.m_drivers_on_the_same_stop;
        Assert.assertThat(expected_drivers, is(new ArrayList(Arrays.asList(driverA, driverB))));
    }

    @Test
    public void CheckCollectedGossips()
    {
        Set<Character> expected_drivers = route_BCN.m_gossips_collected;
        Assert.assertThat(expected_drivers, is(new HashSet(Arrays.asList('A','B'))));
    }

    @Test
    public void CheckDriversNextStop()
    {
        Integer expected_stop = driverA.ActualStop();
        Assert.assertThat(expected_stop, is(1));
    }
}
