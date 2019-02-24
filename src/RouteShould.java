import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        driverB = new BusDriver('B', 3, 2, 2, 1);
        // driverC = new BusDriver('C', 3, 2);

        route_BCN = new Route(driverA, driverB);
    }

    @Test
    public void CheckCollectedActualStops()
    {
        List<Integer> expected_stops = route_BCN.m_actual_drivers_stop;
        List<Integer> stops = new ArrayList<>();
        stops.add(1);
        stops.add(3);
        Assert.assertThat(expected_stops, is(stops));
    }
}
