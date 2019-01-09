import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class RouteShould {

    @Test
    public void GetAllStops()
    {
        BusDriver driverA = new BusDriver('A', 1, 2, 3);
        BusDriver driverB = new BusDriver('B', 3, 1, 3);

        Route route_BCN = new Route(driverA, driverB);

        route_BCN.CollectAllStops();

        int total_stops_need = route_BCN.total_stops;

        Assert.assertThat(total_stops_need, is(3));
    }
}
