package Practice2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {

    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> ans=new ArrayList<Integer>(20);

        TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>(Collections.reverseOrder());

        for(int i=0;i<A.size();i++)
        {
            tm.put(A.get(i),B.get(i));
            ans.add(-1);
        }

        for(Map.Entry<Integer,Integer> e:tm.entrySet())
        {
            int key=e.getKey();
            int val=e.getValue();
            System.out.println(key +" "+ val);
            ans.add(val,key);


        }

        return ans;

    }
}
