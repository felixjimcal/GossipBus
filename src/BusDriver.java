import java.util.*;

public class BusDriver {

    public static Comparator<BusDriver> ComparatorActualStop = new Comparator<BusDriver>() {
        @Override
        public int compare(BusDriver o1, BusDriver o2) {
            Integer stopB1 = o1.ActualStop();
            Integer stopB2 = o1.ActualStop();

            return stopB1.compareTo(stopB2);
        }
    };
    private int actual_index = 0;

    Set<Character> m_gossips = new HashSet<>();
    List<Integer> m_stations = new ArrayList<>();

    BusDriver(Character gossip, Integer... stops) {
        this.m_gossips.add(gossip);
        this.m_stations.addAll(Arrays.asList(stops));
    }

   Integer ActualStop()
   {
       Integer value = 0;

       value = m_stations.get(actual_index);

       return value;
   }

   void NextStop()
   {
       actual_index++;

       if(actual_index == m_stations.size())
       {
           actual_index = 0;
       }
   }
}
