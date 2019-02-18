import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;

public class RouteShould {

    BusDriver driverA;
    BusDriver driverB;

    Route route_BCN;

    @Before
    public void Initialize()
    {
        driverA = new BusDriver('A', 1, 3, 1);
        driverB = new BusDriver('B', 3, 2, 2, 1);
        // driverC = new BusDriver('C', 3, 2);

        route_BCN = new Route(driverA, driverB);
    }

    @Test
    public void RouteHasAllTheDifferentStops()
    {
        Set<Integer> expected_stops = route_BCN.m_stops_in_the_route;
        Assert.assertThat(expected_stops, is(new HashSet<>(Arrays.asList(1,3,2))));
    }

    // Next STOP
}
