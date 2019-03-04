import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class RouteShould {

    BusDriver driverA;
    BusDriver driverB;

    Route route_BCN;

    @Before
    public void Initialize()
    {
        driverA = new BusDriver('A', 1, 3, 1);
        driverB = new BusDriver('B', 1, 2, 2, 1);
        // driverC = new BusDriver('C', 3, 2);

        route_BCN = new Route(driverA, driverB);
    }

    @Test
    public void CheckBusDriversOrder()
    {
        List<Integer> expected_stops = new ArrayList<>();

        for(BusDriver actualDriver : route_BCN.m_drivers_in_the_route)
        {
            expected_stops.add(actualDriver.ActualStop());
        }

        Assert.assertThat(expected_stops, is(new ArrayList(Arrays.asList(1,3))));
    }


}
