import java.util.*;

class Route {

    List<BusDriver> m_drivers_on_the_same_stop = new ArrayList<>();

    int total_stops_to_share_all_the_gossips = 0, minutes = 480;

    List<BusDriver> m_drivers_in_the_route = new ArrayList<>();

    Set<Character> gossips = new HashSet<>();

    Route(BusDriver... drivers) {

        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

        Collections.sort(m_drivers_in_the_route, BusDriver.ComparatorActualStop);

        CollectAllTheGossips();

        for(int stops = 0; stops < m_drivers_in_the_route.size(); stops++)
         {
            int actual_stop = 0, last_stop = 0;

            for(BusDriver driver : m_drivers_in_the_route)
            {
                actual_stop = driver.ActualStop();

                if(actual_stop == last_stop)
                {
                    m_drivers_on_the_same_stop.add(driver);
                }
                else
                {
                    ExchangeGossips();
                }

                last_stop = actual_stop;
            }
        }
    }

    private void CollectAllTheGossips() {
        for(BusDriver driver: m_drivers_in_the_route)
        {
            gossips.addAll(driver.m_gossips);
        }
    }

    private void ExchangeGossips()
    {
        Set<Character> gossips = new HashSet<>();

        for(BusDriver driver : m_drivers_on_the_same_stop)
        {
            gossips.addAll(driver.m_gossips);
        }

        for(BusDriver driver : m_drivers_on_the_same_stop)
        {
            driver.m_gossips.addAll(gossips);
        }
    }
}