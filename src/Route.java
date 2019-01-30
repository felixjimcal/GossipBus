import java.util.*;

class Route {

    Set<Integer> route_stops = new HashSet<>();
    Set<Character> drivers_gossips = new HashSet<>();
    private List<BusDriver> drivers = new ArrayList<>();
    private Set<BusDriver> drivers_on_the_same_stop = new HashSet<>();
    Set<Character> gossips_from_drivers_on_the_same_stop = new HashSet<Character>();

    int total_stops = 0;

    Route(BusDriver... drivers) {
        this.drivers.addAll(Arrays.asList(drivers));

        this.CollectStops();
        this.CollectGossips();
        this.CollectDriversOnTheSameStop();
    }

    private void CollectStops() {
        for (BusDriver my_driver : drivers) {
            route_stops.addAll(my_driver.m_stops);
        }
    }

    private void CollectGossips() {
        for (BusDriver my_driver : drivers) {
            drivers_gossips.addAll(my_driver.gossips);
        }
    }

    private void CollectDriversOnTheSameStop() {
        List<Integer> stops_list = new ArrayList<>(route_stops);

        for (int i = 0; i < route_stops.size(); i++) {
            for (BusDriver driver : drivers) {
                if (driver.m_stops.get(i).equals(stops_list.get(i))) {
                    drivers_on_the_same_stop.add(driver);
                }
            }
            if (drivers_on_the_same_stop.size() > 1) {
                CollectGossipsFromCollectedDrivers();
            }
            drivers_on_the_same_stop.clear();
            total_stops++;
        }
    }

    private void CollectGossipsFromCollectedDrivers() {
        for (BusDriver driver : drivers_on_the_same_stop) {
            gossips_from_drivers_on_the_same_stop.addAll(driver.gossips);
        }

        ExchangeGossips();
    }

    private void ExchangeGossips() {
        for (BusDriver driver : drivers_on_the_same_stop) {
            driver.gossips.addAll(gossips_from_drivers_on_the_same_stop);
        }
    }


}
