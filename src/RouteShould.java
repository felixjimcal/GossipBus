import org.junit.Before;

public class RouteShould {

    BusDriver driverA;
    BusDriver driverB;

    Route route_BCN;

    @Before
    public void Initialize()
    {
        driverA = new BusDriver('A', 1, 3, 1);
        driverB = new BusDriver('B', 3, 2, 2, 1);
        // driverC = new BusDriver('C', 3, 2);

        route_BCN = new Route(driverA, driverB);
    }



}
