package Practice2020;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedNumber {


    public int repeatedNumber(final List<Integer> a) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer i : a) {
            if (hm.containsKey(i)) {
                Integer t = hm.get(i);
                hm.put(i, t + 1);
            } else {
                hm.put(i, 1);
            }
        }

        for (Map.Entry<Integer,Integer> e : hm.entrySet()){
            if(e.getValue() > a.size()/3)
                return e.getKey();
        }

        return -1;
    }
}