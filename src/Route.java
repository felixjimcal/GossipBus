import java.util.*;

class Route {

    int total_stops_to_share_all_the_gossips = 0, minutes = 480;

    List<BusDriver> m_drivers_in_the_route = new ArrayList<>();

    Set<Integer> m_drivers_actual_stop = new HashSet<>();
    Set<BusDriver> m_drivers_on_same_stop = new HashSet<>();

    Set<BusDriver> m_drivers_to_share_gossips = new HashSet<>();

    Route(BusDriver... drivers)
    {
        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

        FindDuplicates();

        FindDriversWithSameStop();
    }

    private void FindDriversWithSameStop()
    {
        Iterator<BusDriver> iterator = m_drivers_on_same_stop.iterator();

        while(iterator.hasNext())
        {
            BusDriver nextDriver = iterator.next();

            if(nextDriver.ActualStop().equals(iterator.next().ActualStop()))
            {

            }
            else
        }
    }

    private void FindDuplicates()
    {
        for(BusDriver driver : m_drivers_in_the_route)
        {
            if(!m_drivers_actual_stop.add(driver.ActualStop()))
            {
                m_drivers_on_same_stop.add(driver);
            }
        }
    }
}