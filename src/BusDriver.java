import java.util.*;

public class BusDriver {

    BusDriver(Character gossip, Integer ... stops){
        this.gossips.add(gossip);
        this.m_stops.addAll(Arrays.asList(stops));
    }

    Set<Character> gossips = new HashSet<>();;

    List<Integer> m_stops = new ArrayList<>();


}
