package Practice2020;

import java.util.ArrayList;

public class PaintersPartition2 {

    public int paint(int A, int B, ArrayList<Integer> C) {
        long low =0;
        long high = Integer.MAX_VALUE;  // max time
        long mintime = high;
        while(low <= high){
            long mid = (low + high)/2;
            if(isPossible(mid,A,  B,  C)){
                mintime = mid;
                high = mid -1;
            } else {
                low = mid+1;
            }
        }

        return (int)(mintime % 10000003);

    }

    private boolean isPossible(long mid, int a, int b, ArrayList<Integer> c) {
        long time =0;
        a = a-1;
        for(int i=0; i<c.size() && a >= 0; i++){
            int val = c.get(i);
            long t = b*val;
            if(t > mid || t<0)
                return false;
            if((time + t ) > mid) {
                a = a-1;
                time = t;
            } else {
                time += t;
            }


        }
        if(a<0)
            return false;

        return true;
    }
}
