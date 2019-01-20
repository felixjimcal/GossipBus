import java.util.*;

public class BusDriver {

    BusDriver(Character gossip, Integer ... stops){
        this.gossips.add(gossip);
        this.stops.addAll(Arrays.asList(stops));
    }

    Set<Character> gossips = new HashSet<>();;

    public List<Integer> getStops() {
        return stops;
    }

    List<Integer> stops = new ArrayList<>();


}
