import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    }

}
