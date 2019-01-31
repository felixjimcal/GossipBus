import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;


public class RouteShould {

    BusDriver driverA, driverB, driverC;
    Route route_BCN;

    @Before
    public void intitialize() {
        driverA = new BusDriver('A', 1, 3, 1);
        driverB = new BusDriver('B', 1, 3, 2);
        driverC = new BusDriver('C', 3, 2);

        route_BCN = new Route(driverA, driverB, driverC);

    }

    @Test
    public void GetTotalStops() {
        int total_stops_need = route_BCN.route_stops.size();

        Assert.assertThat(total_stops_need, is(3));
    }

    @Test
    public void CheckStopsCollected() {
        Set<Integer> stops_expected = route_BCN.route_stops;

        Assert.assertThat(stops_expected, is(new HashSet<>(Arrays.asList(1, 3, 2))));
    }

    @Test
    public void CheckGossips() {
        Set<Character> gossips_expected = route_BCN.drivers_gossips;

        Assert.assertThat(gossips_expected, is(new HashSet<>(Arrays.asList('A', 'B', 'C'))));
    }

    @Test
    public void CheckGossipsFromCollectedBusDrivers()
    {
        Set<Character> gossips_expected = route_BCN.gossips_from_drivers_on_the_same_stop;
        Assert.assertThat(gossips_expected, is(new HashSet<>(Arrays.asList('A','B', 'C'))));
    }
}
