import java.util.*;

public class BusDriver {

    private int actual_index = 0;

    BusDriver(Character gossip, Integer ... stops){
        this.m_gossips.add(gossip);
        this.m_stations.addAll(Arrays.asList(stops));
    }

    Set<Character> m_gossips = new HashSet<>();;

    List<Integer> m_stations = new ArrayList<>();

    Integer NextStop()
    {
        int value = 0;

        value = m_stations.get(actual_index);
        actual_index++;

        if(actual_index == m_stations.size())
        {
            actual_index = 0;
            value = m_stations.get(actual_index);
        }

        return value;
    }
}
