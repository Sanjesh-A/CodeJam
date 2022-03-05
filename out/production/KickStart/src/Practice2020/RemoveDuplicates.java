package Practice2020;

import java.util.ArrayList;

public class RemoveDuplicates {
    public int removeDuplicates1(ArrayList<Integer> a) {
        int i = 1;
        while( i<a.size()){
            while( i<a.size() && ((long)a.get(i-1) == (long) a.get(i))){
                a.remove(i);
                // i++;
            }

            i++;
        }
        return a.size();
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        int i = 0;
        while(i < a.size()){
            int j = findLastIndexOfDuplicate(a,i+1, a.get(i));
            for(int k = j-i; j!=-1 && k>0;k--){
                a.remove(i+1);
            }
            i++;
        }
        return a.size();

    }

    private int findLastIndexOfDuplicate(ArrayList<Integer> a, int i, int key) {
        int n = a.size();
        int low = i;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(key == a.get(mid)){
                if(low == mid) {
                    if(key == (a.get(high)))
                        return high;
                    else
                        return low;
                }
                low = mid;
            } else if(key > a.get(mid) ){
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
