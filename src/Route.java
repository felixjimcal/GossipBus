import java.util.*;

class Route {

    List m_drivers_on_the_same_stop;
    int total_stops_to_share_all_the_gossips = 0, minutes = 480;

    List<BusDriver> m_drivers_in_the_route = new ArrayList<>();

    Route(BusDriver... drivers) {

        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

        Collections.sort(m_drivers_in_the_route, BusDriver.ComparatorActualStop);

    }
}