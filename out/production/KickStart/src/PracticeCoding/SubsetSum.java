package PracticeCoding;

import java.util.HashMap;

public class SubsetSum {

    public HashMap<String,Integer> cache = new HashMap<>();
    public int cacheHits = 0;

    public  int getCountOfSubsets(int[] a, int start, int sum){
        String key = Integer.toString(sum)+ ":"  + Integer.toString(start);
        if(cache.containsKey(key)){
            cacheHits++;
            return cache.get(key);
        }

        if(sum == 0)
            return 1;

        if(sum < 0 || start >= a.length)
            return 0;

        int count1 = getCountOfSubsets(a, start+1, sum - a[start]);
        int count2 = getCountOfSubsets(a, start+1, sum);
        cache.put(key,count1+count2);
        return count1+count2;
    }
}
