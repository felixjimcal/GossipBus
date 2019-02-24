import java.util.*;

class Route {

    List m_drivers_on_the_same_stop;
    List<Integer> m_actual_drivers_stop = new ArrayList<>();
    int total_stops_to_share_all_the_gossips = 0, minutes = 480;

    Set<BusDriver> m_drivers_in_the_route = new LinkedHashSet<>();

    Set<BusDriver> drivers_on_same_station = new HashSet<>();

    Route(BusDriver... drivers) {

        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

        CollectBusDriversActualStop();

        CollectBusDriversOnTheSameStation();

        if(drivers_on_same_station.size() > 1)
        {

        }
    }

    private void CollectBusDriversOnTheSameStation() {
        for (BusDriver driver : m_drivers_in_the_route) {

        }
    }

    private void CollectBusDriversActualStop() {
        for (BusDriver driver : m_drivers_in_the_route) {
            m_actual_drivers_stop.add(driver.ActualStop());
        }
    }
}