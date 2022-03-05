package Practice2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        int n = A.size();
        long total = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        int i =0;
        while( i<n){
            if(i>0){
                System.out.println(A.get(i-1));
                System.out.println(A.get(i));

                while( i<n && ((long)A.get(i-1) == (long) A.get(i)))
                    i++;
                if(i == n)
                    break;
            }
            int val = A.get(i);
            long sum = total - val;
            int low = i+1;
            int high = n-1;
            while( low < high ){
                int v1 = A.get(low);
                int v2 = A.get(high);
                if((long)v1+v2 == sum){
                    Integer[] a = {val, v1, v2};
                    ArrayList<Integer> alist = new ArrayList<Integer>(Arrays.asList(a));
                    result.add(alist);
                    while(low<high && A.get(++low)==v1);
                    while(low<high && A.get(--high) == v2);
                } else if(v1+v2 > sum){
                    high--;
                } else {
                    low++;
                }
            }
            i++;
        }

        return result;
    }
}
