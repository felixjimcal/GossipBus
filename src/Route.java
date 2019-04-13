import java.util.*;

class Route {

    int total_stops_to_share_all_the_gossips = 0, minutes = 480;

    private List<BusDriver> m_drivers_in_the_route = new ArrayList<>();
    Set<Integer> m_actual_repeated_stops = new HashSet<>();
    List<BusDriver> m_drivers_on_the_same_stop = new ArrayList<>();
    Set<Character> m_gossips_collected = new HashSet<>();
    Set<Character> m_all_the_gossips = new HashSet<>();

    Route(BusDriver... drivers)
    {
        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

        CollectAllGossips();

         for(int i = 0; i < minutes; i++)
         {
            GetActualRepeatedStations();

            GetDriversOnTheSameStationOnActualStop();

            total_stops_to_share_all_the_gossips++;

            if(AreAllTheGossipsShared())
            {
                ShowMessage(String.valueOf(total_stops_to_share_all_the_gossips));
                break;
            }

            if(total_stops_to_share_all_the_gossips == minutes)
            {
                ShowMessage("Never");
            }

            AllDriversGoToTheNextStop();
            CleanLists();
        }
    }

    private void CollectAllGossips() {
        for(BusDriver driver : m_drivers_in_the_route)
        {
            m_all_the_gossips.addAll(driver.m_gossips);
        }
    }

    private void CleanLists() {
        m_actual_repeated_stops.clear();
        m_drivers_on_the_same_stop.clear();
        m_gossips_collected.clear();
    }

    private void ShowMessage(String message) {
        System.out.println(message);
    }

    private boolean AreAllTheGossipsShared()
    {
        boolean result = false;
        int drivers_with_all_the_gossips = 0;

        for(BusDriver driver : m_drivers_in_the_route)
        {
            if(driver.m_gossips.size() == m_all_the_gossips.size())
            {
                drivers_with_all_the_gossips++;
            }
        }

        if(drivers_with_all_the_gossips == m_drivers_in_the_route.size())
        {
            result = true;
        }

        return result;
    }

    private void AllDriversGoToTheNextStop()
    {
        for(BusDriver driver : m_drivers_in_the_route)
        {
            driver.NextStop();
        }
    }

    private void GetDriversOnTheSameStationOnActualStop() {
        for (Integer stop : m_actual_repeated_stops)
        {
            for(BusDriver driver : m_drivers_in_the_route)
            {
                if(driver.ActualStop().equals(stop))
                {
                    m_drivers_on_the_same_stop.add(driver);
                }
            }

            CollectGossipsFromDrivers();
            m_drivers_on_the_same_stop.clear();
        }
    }

    private void ExchangeGossips() {
        for(BusDriver driver : m_drivers_on_the_same_stop)
        {
            driver.m_gossips.addAll(m_gossips_collected);
        }
    }

    private void CollectGossipsFromDrivers()
    {
        if(m_drivers_on_the_same_stop.size() < 2)
        {
            return;
        }

        for(BusDriver driver : m_drivers_on_the_same_stop)
        {
            m_gossips_collected.addAll(driver.m_gossips);
        }

        ExchangeGossips();
        m_gossips_collected.clear();
    }

    private void GetActualRepeatedStations()
    {
        Set<Integer> stops = new HashSet<>();

        for(BusDriver driver : m_drivers_in_the_route)
        {
            if(!stops.add(driver.ActualStop()))
            {
                m_actual_repeated_stops.add(driver.ActualStop());
            }
        }
    }
}