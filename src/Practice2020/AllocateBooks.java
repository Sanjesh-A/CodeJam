package Practice2020;

import java.util.ArrayList;

public class AllocateBooks {
    public int books(ArrayList<Integer> A, int B) {
        int n = A.size();
        int low = 0;
        int high = 0;
        for(Integer i : A){
            high += i;
            if(low < i)
                low = i;
        }

        int minMaxPages = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(isPossible(A, B, mid)){
                minMaxPages = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return minMaxPages;
    }

    private boolean isPossible(ArrayList<Integer> a, int b, int mid) {

        b = b-1;
        int pages= 0;
        for(int i=0; i<a.size() && b >= 0; i++){
            int val = a.get(i);
            if(val > mid)
                return false;

            if(pages+val > mid){
                b = b-1;
                pages = val;
            } else {
                pages += val;
            }
        }

        if (b!=0)
            return false;

        return true;
    }

}
