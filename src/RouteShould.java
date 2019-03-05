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
    public void CheckBusDriversOrder()
    {
        List<Integer> expected_stops = new ArrayList<>();

        for(BusDriver actualDriver : route_BCN.m_drivers_in_the_route)
        {
            expected_stops.add(actualDriver.ActualStop());
        }

        Assert.assertThat(expected_stops, is(new ArrayList(Arrays.asList(1,3,4))));
    }

    @Test
    public void CheckAllGossips()
    {
        Set<Character> expected_gossips = route_BCN.all_possible_gossips;
        Assert.assertThat(expected_gossips, is(new HashSet(Arrays.asList('A','B','C'))));
    }

    @Test
    public void CheckGossipExchanged()
    {
        Set<Character> expected_exchanged = new HashSet<>(Arrays.asList('A','B', 'C'));
        Assert.assertThat(driverA.m_gossips, is(expected_exchanged));
    }
}
