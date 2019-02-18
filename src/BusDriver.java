import java.util.*;

public class BusDriver {

    private int actual_index = 0;

    Set<Character> m_gossips = new HashSet<>();
    List<Integer> m_stations = new ArrayList<>();

    BusDriver(Character gossip, Integer... stops) {
        this.m_gossips.add(gossip);
        this.m_stations.addAll(Arrays.asList(stops));
    }

   public Integer NextStop()
   {
       Integer value = 0;

       value = m_stations.get(actual_index);
       actual_index++;

       if(actual_index == m_stations.size())
       {
           actual_index = 0;
       }

       return value;
   }
}
