import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;


public class RouteShould {

    BusDriver driverA,driverB;
    Route route_BCN;

    @Before
    public void intitialize()
    {
        driverA = new BusDriver('A', 1, 2, 3);
        driverB = new BusDriver('B', 3, 1, 3);

        route_BCN = new Route(driverA, driverB);
    }

    @Test
    public void GetTotalStops()
    {
        int total_stops_need = route_BCN.GetTotalStops();

        Assert.assertThat(total_stops_need, is(6));
    }

    @Test
    public void CheckStops()
    {
        Set<Integer> stops_expected = route_BCN.GetStops();

        Assert.assertThat(stops_expected, is(new HashSet<>(Arrays.asList(1,2,3))));
    }

    @Test
    public void CheckGossips()
    {
        Set<Character> gossips_expected = route_BCN.GetGossips();

        Assert.assertThat(gossips_expected, is(new HashSet<>(Arrays.asList('A','B'))));
    }

}
