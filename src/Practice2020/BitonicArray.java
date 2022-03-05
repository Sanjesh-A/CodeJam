package Practice2020;

import java.util.ArrayList;

public class BitonicArray {


    public int solve(ArrayList<Integer> A, int B) {
        int size = A.size();
        int low = 0;
        int high = size-1;
        return solve(A,low, high, B);
    }

    public int solve(ArrayList<Integer> A, int low, int high, int B) {
        if(low <= high){
            int mid = (low + high)/2;
            if(B == A.get(mid))
                return mid;
            if(mid > low && mid < high){
                if(A.get(mid) > A.get(mid-1)){
                    if(A.get(mid) < A.get(mid+1)){
                        if (B< A.get(mid))
                            return solve(A,low, mid-1, B);
                        else
                            return solve(A,mid+1, high, B);
                    } else {
                        if (B< A.get(mid)){
                            int i = solve(A,low, mid-1, B);
                            if(i!= -1)
                                return i;
                            return solve(A,mid+1, high, B);
                        }
                    }
                } else {
                    if (B< A.get(mid))
                        return solve(A,mid+1, high, B);
                    else
                        return solve(A,low, mid-1, B);

                }
            } else {
                if (B< A.get(mid))
                    return solve(A,low, mid-1, B);
                else
                    return solve(A,mid+1, high, B);
            }

        }

        return -1;
    }



}
