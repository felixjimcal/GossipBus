import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class  KnowAllTheStops{

    @Test
    public void ThreeStopsToKnowAllTheGossips()
        {
            BusDriver driverA = new BusDriver('A', 1,2,3);
            BusDriver driverB = new BusDriver('B', 3,1,3);

            Route route_BCN = new Route(driverA, driverB);

            int total_stops_need = route_BCN.total_stops;

            // Obtener SÓLO el total de paradas
            Assert.assertThat(total_stops_need, is(3));
        }
}
