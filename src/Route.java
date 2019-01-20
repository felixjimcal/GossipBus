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



    public int GetTotalStops() {

        for(int i = 0; i < my_drivers.size(); i++)
        {
            total_stops += my_drivers.get(i).stops.size();
        }

        return total_stops;
    }
}
