import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Route {

    int total_stops = 0;

    List<BusDriver> my_drivers = new ArrayList<>();

    Route(BusDriver... drivers)
    {
        this.my_drivers.addAll(Arrays.asList(drivers));
    }

    // Divide and conquer
    // If we collect all the stops we can know the total of these
    // then we can separate the drivers that are in that same stop
    public void CollectAllStops() {
        total_stops = 3;
    }
}
