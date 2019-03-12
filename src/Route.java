import java.util.*;

class Route {

    int total_stops_to_share_all_the_gossips = 0, minutes = 480;

    private List<BusDriver> m_drivers_in_the_route = new ArrayList<>();
    public Set<Integer> m_drivers_actual_stop = new HashSet<>();
    public List<BusDriver> m_drivers_on_the_same_stop = new ArrayList<>();

    Route(BusDriver... drivers)
    {
        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

        GetActualStops();

        GetDriversOnTheSameActualStop();
    }

    private void GetDriversOnTheSameActualStop() {
        for (Integer stop : m_drivers_actual_stop )
        {
            for(BusDriver driver : m_drivers_in_the_route)
            {
                if(driver.ActualStop().equals(stop))
                {
                    m_drivers_on_the_same_stop.add(driver);
                }
            }

            ExchangeGossips();
        }
    }

    private void ExchangeGossips() {
        // Coleccionza los gossips, nuevo metodo

        // Intercambia los cotilleos en un nuevo metodo
    }

    private void GetActualStops()
    {
        for(BusDriver driver : m_drivers_in_the_route)
        {
            m_drivers_actual_stop.add(driver.ActualStop());
        }
    }
}