package PracticeCoding;

import java.util.HashSet;

public class MissingNumber {
    public static void solve(int[] A, int n){
        int sum =0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            if(set.contains(A[i])){
                System.out.println(A[i]);
            } else {
                set.add(A[i]);
                sum += A[i];
            }
        }

        int nsum = n * (n+1)/2;

        System.out.println(nsum - sum);

    }
}
