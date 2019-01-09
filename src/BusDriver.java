import java.util.*;

public class BusDriver {

    BusDriver(Character gossip, Integer ... stops){
        this.gossips.add(gossip);
        this.stops.addAll(Arrays.asList(stops));
    }

    Set<Character> gossips = new HashSet<>();;
    List<Integer> stops = new ArrayList<>();;

}
