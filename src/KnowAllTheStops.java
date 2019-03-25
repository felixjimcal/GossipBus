import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class KnowAllTheStops {

    BusDriver driverA;
    BusDriver driverB;
    BusDriver driverC;

    Route route_BCN;

    @Before
    public void Initialize()
    {

    }

    @Test
    public void FiveStopsToKnowAllTheGossips() {

        driverA = new BusDriver('A', 3, 1, 2, 3);
        driverB = new BusDriver('B', 3, 2, 3, 1);
        driverC = new BusDriver('C', 4, 2, 3, 4, 5);

        route_BCN = new Route(driverA, driverB, driverC);

        int total_stops_need = route_BCN.total_stops_to_share_all_the_gossips;

        Assert.assertThat(total_stops_need, is(5));
    }

    @Test
    public void NeverEnd() {

        driverA = new BusDriver('A', 2, 1, 2);
        driverB = new BusDriver('B', 5, 2, 8);

        route_BCN = new Route(driverA, driverB);

        int total_stops_need = route_BCN.total_stops_to_share_all_the_gossips;

        Assert.assertThat(total_stops_need, is(route_BCN.minutes));
    }
}
