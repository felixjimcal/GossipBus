import java.util.*;

class Route {

    List<BusDriver> m_drivers_on_the_same_stop = new ArrayList<>();

    int total_stops_to_share_all_the_gossips = 0, minutes = 480;

    List<BusDriver> m_drivers_in_the_route = new ArrayList<>();

    Set<Character> all_possible_gossips = new HashSet<>();

    List<BusDriver> actual_drivers = new ArrayList<>();

    Route(BusDriver... drivers)
    {
        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

        SortDriversInRoute();

        CollectAllTheGossips();

        for(int stops = 0; stops < m_drivers_in_the_route.size(); stops++)
        {
            for(BusDriver driver : m_drivers_in_the_route)
            {
               actual_drivers.add(driver);

               CheckDriversStops();

               driver.NextStop();
            }
        }
    }

    private void SortDriversInRoute() {
        actual_drivers.sort(Comparator.comparing(BusDriver::ActualStop));
    }

    private void CheckDriversStops() {
        Set<Integer> stops = new HashSet<>();

        for(BusDriver driver : actual_drivers)
        {
            stops.add(driver.ActualStop());
        }

        if(stops.size() == 1)
        {
            ExchangeGossips();
        }
        else
        {
            actual_drivers.clear();
        }
    }

    private void CollectAllTheGossips()
    {
        for(BusDriver driver: m_drivers_in_the_route)
        {
            all_possible_gossips.addAll(driver.m_gossips);
        }
    }

    private void ExchangeGossips()
    {
        Set<Character> gossips = new HashSet<>();

        for(BusDriver driver : actual_drivers)
        {
            gossips.addAll(driver.m_gossips);
        }

        for(BusDriver driver : actual_drivers)
        {
            driver.m_gossips.addAll(gossips);
        }
    }
}