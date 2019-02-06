import java.util.*;

class Route {

    private int work_minutes = 480;
    Set<Integer> route_stops = new HashSet<>();
    Set<Character> all_gossips = new HashSet<>();
    private List<BusDriver> drivers_on_the_route = new ArrayList<>();
    private Set<BusDriver> drivers_on_the_same_stop = new HashSet<>();
    Set<Character> gossips_from_drivers_on_the_same_stop = new HashSet<Character>();

    int total_stops = 0;

    Route(BusDriver... drivers) {
        this.drivers_on_the_route.addAll(Arrays.asList(drivers));

        this.CollectStops();
        this.CollectGossips();
        this.CollectDriversOnTheSameStop();
    }

    private void CollectStops() {
        for (BusDriver my_driver : drivers_on_the_route) {
            route_stops.addAll(my_driver.m_stops);
        }
    }

    private void CollectGossips() {
        for (BusDriver my_driver : drivers_on_the_route) {
            all_gossips.addAll(my_driver.gossips);
        }
    }

    private void CollectDriversOnTheSameStop() {
        List<Integer> stops_list = new ArrayList<>(route_stops);

        for (int minutes = 0; minutes < work_minutes; minutes++) {
            for (int bus_stops = 0; bus_stops < route_stops.size(); bus_stops++) {
                for (BusDriver driver : drivers_on_the_route) {
                    if (driver.m_stops.get(bus_stops).equals(stops_list.get(bus_stops))) {
                        drivers_on_the_same_stop.add(driver);
                    }
                }
                // No estan entrando los conductores con la misma parada...
                if (drivers_on_the_same_stop.size() > 1) {
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
            }
        }
    }

    private void CollectGossipsFromCollectedDrivers() {
        for (BusDriver driver : drivers_on_the_same_stop) {
            gossips_from_drivers_on_the_same_stop.addAll(driver.gossips);
        }

        ExchangeGossips();
    }

    private boolean AllGossipsAreShared() {
        boolean result = false;

        for (BusDriver driver : drivers_on_the_route) {
            if (driver.gossips.size() == all_gossips.size()) {
                result = true;
            }
        }
        return result;
    }

    private void ExchangeGossips() {
        for (BusDriver driver : drivers_on_the_same_stop) {
            driver.gossips.addAll(gossips_from_drivers_on_the_same_stop);
        }
    }


}
