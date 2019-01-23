import java.util.*;

public class Route {

    Set<Integer> stops = new HashSet<>();
    Set<Character> gossips = new HashSet<>();
    List<BusDriver> my_drivers = new ArrayList<>();
    private int eight_hours_minutes = 480;

    Set<BusDriver> drivers_on_the_same_stop = new HashSet<>();

    Route(BusDriver... drivers)
    {
        this.my_drivers.addAll(Arrays.asList(drivers));
    }

    public int GetTotalStops() {
        return stops.size();
    }

    public void CollectStops()
    {
        for(int i = 0; i < my_drivers.size(); i++)
        {
            stops.addAll(my_drivers.get(i).m_stops);
        }
    }

    public void CollectGossips() {

        for(int i = 0; i < my_drivers.size(); i++)
        {
            gossips.addAll(my_drivers.get(i).gossips);
        }
    }

    public void CollectDriversOnTheSameStop()
    {
        CollectStops();
        CollectGossips();

        do
        {
            for(int i = 0; i < eight_hours_minutes; i++)
            {
                for (BusDriver driver: my_drivers)
                {
                    if(stops.iterator().next() == driver.m_stops.get(i))
                    {
                        drivers_on_the_same_stop.add(driver);
                    }
                }
            }
        }
        while(eight_hours_minutes != 0);
    }

}
