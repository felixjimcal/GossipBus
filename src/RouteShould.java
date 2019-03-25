import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

public class RouteShould {

    BusDriver driverA;
    BusDriver driverB;
    BusDriver driverC;

    Route route_BCN;

    @Before
    public void Initialize()
    {
        driverA = new BusDriver('A', 3, 1, 2, 3);
        driverB = new BusDriver('B', 3, 2, 3, 1);
        driverC = new BusDriver('C', 4, 2, 3, 4, 5);

        route_BCN = new Route(driverA, driverB, driverC);
    }

    @Test
    public void CheckActualRepeatedStops()
    {
        Set<Integer> expected_stops = route_BCN.m_actual_stops;
        Assert.assertThat(expected_stops, is(new HashSet(Arrays.asList(2, 3))));
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
