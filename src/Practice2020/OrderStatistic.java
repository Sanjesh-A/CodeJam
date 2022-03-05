package Practice2020;

import java.util.Map;
import java.util.TreeMap;

public class OrderStatistic {
    int getOS(int[] A, int index)  {
       int low = 0;
       int high = A.length-1;
       if(index < low || index > high) {
           throw new ArrayIndexOutOfBoundsException("index is out of bound.");
       }
       while(low < high){
           int p = partition(A,low,high);
           if(p==index)
               return A[p];
           if(index < p){
               high = p -1;
           } else {
               low = p+1;
           }

       }

       return A[index]; // low == high == index


    }

    private int partition(int[] A, int low, int high) {
        int t = A[low];
        int pos  = low;
        low = low+1;
        while(low < high){
            while(low<high && A[low]<= t)
                low++;
            while(low<high && A[high] > t)
                high--;

            if(low<high){
                int temp = A[high];
                A[high] = A[low];
                A[low] =  temp;
            }
        }

        A[pos] = A[low-1];
        A[low-1] = t;
        return low-1;

    }

    int getRank(int[] A, int value){
        int low = 0;
        int high = A.length - 1;
        while(low < high){
            int p = partition(A,low, high);
            if(A[p] == value)
                return p;
            if(value < A[p]){
                high = p -1;
            } else {
                low = p+1;
            }

        }

        return -1;
    }
}
