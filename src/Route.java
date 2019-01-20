import java.util.*;

public class Route {

    Set<Integer> stops = new HashSet<>();
    Set<Character> gossips = new HashSet<>();
    List<BusDriver> my_drivers = new ArrayList<>();

    Route(BusDriver... drivers)
    {
        this.my_drivers.addAll(Arrays.asList(drivers));
    }

    public int GetTotalStops() {
        return stops.size();
    }

    public Set<Integer> GetStops()
    {
        for(int i = 0; i < my_drivers.size(); i++)
        {
            stops.addAll(my_drivers.get(i).stops);
        }

        return stops;
    }

    public Set<Character> GetGossips() {

        for(int i = 0; i < my_drivers.size(); i++)
        {
            gossips.addAll(my_drivers.get(i).gossips);
        }

        return gossips;
    }
}
