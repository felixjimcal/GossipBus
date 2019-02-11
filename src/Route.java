import java.util.*;

class Route {

    int route_stops = 0;
    Set<Integer> route_stations = new HashSet<>();
    Set<Character> all_gossips = new HashSet<>();
    private List<BusDriver> drivers_on_the_route = new ArrayList<>();
    private Set<BusDriver> drivers_on_the_same_stop = new HashSet<>();
    Set<Character> gossips_from_drivers_on_the_same_stop = new HashSet<Character>();

    int total_stops = 0;

    Route(BusDriver... drivers) {
        this.drivers_on_the_route.addAll(Arrays.asList(drivers));

        this.CollectBusStations();
        this.CollectStops();
        this.CollectGossips();
        this.CollectDriversOnTheSameStop();
    }

    /**
     * Collect the total of Bus stations 3, 2, 3, 1 = 3 Stations
     */
    private void CollectBusStations() {
        for (BusDriver my_driver : drivers_on_the_route) {
            route_stations.addAll(my_driver.m_stations);
        }
    }

    /**
     * Collect the total of Bus stops 3, 2, 3, ,1 = 4 stops
     */
    private void CollectStops() {
        for (BusDriver driver : drivers_on_the_route) {
            if(driver.m_stations.size() > route_stops)
            {
                route_stops = driver.m_stations.size();
            }
        }
    }

    private void CollectGossips() {
        for (BusDriver my_driver : drivers_on_the_route) {
            all_gossips.addAll(my_driver.m_gossips);
        }
    }

    private void CollectDriversOnTheSameStop() {

        int work_minutes = 480;
        List<Integer> stations_list = new ArrayList<Integer>(route_stations);

        for (int minutes = 0; minutes < work_minutes; minutes++)
        {
            for (int i = 0; i < route_stops; i++)
            {
                for (BusDriver driver : drivers_on_the_route)
                {
                    // PArece que ruta tambien es un colaborador inteligente
                    // Debe devolver la proxima parada, ya que el indice se sale de margen
                    // estamos reclamando la parada 4 y solo tenemos 3
                    // Redefinir disenyo de la aplicacion
                    // O controlar la situacion en medio del bucle, GUARRADA
                    // O hacer de ruta un colaborador en condiciones, CURRAZO
                    // Hay que establecer el "main" en otra parte
                    // A darle
                    int stop = driver.NextStop();
                    int stap = stations_list.get(i);
                    System.out.println(stop);
                    /*
                    if (driver.NextStop().equals(stations_list.get(i)))
                    {
                        drivers_on_the_same_stop.add(driver);
                    }
                    */
                }
                /*
                if (drivers_on_the_same_stop.size() > 1)
                {
                    CollectGossipsFromCollectedDrivers();
                }
                drivers_on_the_same_stop.clear();
                total_stops++;

                if (AllGossipsAreShared()) {
                    System.out.println("Se acabo");
                }
                else
                {
                    System.out.println("Total stops:" + total_stops);
                }
                */
            }
        }
    }

    private void CollectGossipsFromCollectedDrivers() {
        for (BusDriver driver : drivers_on_the_same_stop) {
            gossips_from_drivers_on_the_same_stop.addAll(driver.m_gossips);
        }

        ExchangeGossips();
    }

    private boolean AllGossipsAreShared() {
        boolean result = false;

        for (BusDriver driver : drivers_on_the_route) {
            if (driver.m_gossips.size() == all_gossips.size()) {
                result = true;
            }
        }
        return result;
    }

    private void ExchangeGossips() {
        for (BusDriver driver : drivers_on_the_same_stop) {
            driver.m_gossips.addAll(gossips_from_drivers_on_the_same_stop);
        }
    }


}
