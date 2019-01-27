import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;


public class RouteShould {

    BusDriver driverA, driverB;
    Route route_BCN;

    @Before
    public void intitialize() {
        driverA = new BusDriver('A', 1, 2, 3);
        driverB = new BusDriver('B', 1, 3, 2);

        route_BCN = new Route(driverA, driverB);
        route_BCN.CollectStops();
        route_BCN.CollectGossips();
      //  route_BCN.CollectDriversOnTheSameStop();
    }

    @Test
    public void GetTotalStops() {
        int total_stops_need = route_BCN.GetTotalStops();

        Assert.assertThat(total_stops_need, is(3));
    }

    @Test
    public void CheckStopsCollected() {
        Set<Integer> stops_expected = route_BCN.stops;

        Assert.assertThat(stops_expected, is(new HashSet<>(Arrays.asList(1, 2, 3))));
    }

    @Test
    public void CheckGossips() {
        Set<Character> gossips_expected = route_BCN.gossips;

        Assert.assertThat(gossips_expected, is(new HashSet<>(Arrays.asList('A', 'B'))));
    }

    @Test
    public void CheckDriversOnTheSameStop() {
        Set<BusDriver> gossips_expected = route_BCN.drivers_on_the_same_stop;

        Assert.assertThat(gossips_expected, is(new HashSet<>(Arrays.asList(new BusDriver('A', 1), new BusDriver('B', 1)))));
    }
}
