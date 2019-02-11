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
        driverB = new BusDriver('B', 3, 2, 2, 1);
       // driverC = new BusDriver('C', 3, 2);

        route_BCN = new Route(driverA, driverB);
    }

    @Test
    public void GetTotalStopsInTheRoute() {
        int total_stops_need = route_BCN.route_stops;

        Assert.assertThat(total_stops_need, is(4));
    }

    @Test
    public void CheckStationsCollected() {
        Set<Integer> stops_expected = route_BCN.route_stations;

        Assert.assertThat(stops_expected, is(new HashSet<>(Arrays.asList(1, 2, 3))));
    }

    @Test
    public void CheckGossips() {
        Set<Character> gossips_expected = route_BCN.all_gossips;

        Assert.assertThat(gossips_expected, is(new HashSet<>(Arrays.asList('A', 'B'))));
    }

    @Test
    public void TotalStopsToShareAllTheGossips() {
        int total_stops_need = route_BCN.total_stops;

        Assert.assertThat(total_stops_need, is(2));
    }

    /*
    @Test
    public void CheckGossipsFromCollectedBusDrivers()
    {
        Set<Character> gossips_expected = route_BCN.gossips_from_drivers_on_the_same_stop;
        Assert.assertThat(gossips_expected, is(new HashSet<>(Arrays.asList('A','B', 'C'))));
    }
    */
}
