import java.util.*;

class Route {

    int total_stops_to_share_all_the_gossips = 0, minutes = 480;

    List<BusDriver> m_drivers_in_the_route = new ArrayList<>();

    List<Integer> drivers_actual_stop = new ArrayList<>();

    Route(BusDriver... drivers)
    {
        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

        GetActualStopFromDrivers();

        FindDuplicates();
    }

    private void FindDuplicates() {
        // Encuentra los duplicados
        // Entonces busca que conducctores estan en una de las paradas duplicadas
        // Entonces guarda esos codnuctores en otra lista y luegos haces el intercambio
        // Sure?
    }

    private void GetActualStopFromDrivers() {
        for(BusDriver driver: m_drivers_in_the_route)
        {
            drivers_actual_stop.add(driver.ActualStop());
        }
    }
}