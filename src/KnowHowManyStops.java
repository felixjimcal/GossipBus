import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

class KnowAllTheStops {

    @Test
    public void ThreeStopsToKnowAllTheGossips() {
            /*
            BusDriver driverA = new BusDriver('A', 3, 1, 2, 3);
            BusDriver driverB = new BusDriver('B', 3, 2, 3, 1);
            BusDriver driverC = new BusDriver('C', 4, 2, 3, 4, 5);
            */

        BusDriver driverA = new BusDriver('A', 1, 3, 1);
        BusDriver driverB = new BusDriver('B', 3, 2, 2, 1);
        // driverC = new BusDriver('C', 3, 2);

        Route route_BCN = new Route(driverA, driverB);

        int total_stops_need = route_BCN.total_stops_to_share_all_the_gossips;

        Assert.assertThat(total_stops_need, is(5));
    }
}
