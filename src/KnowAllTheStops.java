import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class KnowAllTheStops {

    BusDriver driverA, driverB, driverC, driverD, driverE, driverF, driverG;

    Route route_BCN;

    @Before
    public void Initialize()
    {

    }

    @Test
    public void FiveStopsToKnowAllTheGossips() {

        driverA = new BusDriver('A', 7,11,2,2,4,8,2,2);
        driverB = new BusDriver('B', 3,0,11,8);
        driverC = new BusDriver('C', 5,11,8,10,3,11);
        driverD = new BusDriver('D', 5,9,2,5,0,3);
        driverE = new BusDriver('E', 7,4,8,2,8,1,0,5);
        driverF = new BusDriver('F', 3,6,8,9);
        driverG = new BusDriver('G', 4,2,11,3,3);

        route_BCN = new Route(driverA, driverB, driverC, driverD, driverE, driverF, driverG);

        int total_stops_need = route_BCN.total_stops_to_share_all_the_gossips;

        Assert.assertThat(total_stops_need, is(8));
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
