package PracticeCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayIntersection {
    public static int[] solve(int[] A, int[] B, int[] C, int n){
        int x = 0;
        int y = 0;
        int z = 0;
        int[] D = new int[n];
        int i = 0;

        while(x < n && y < n && z < n){
            if(A[x] == B[y] && B[y] == C[z]){
                D[i++] = A[x];
                x++; y++; z++;
            } else if(A[x] == B[y] && C[z] < B[y]){
                z++;
            } else if(B[y] < A[x]){
                y++;
            } else {
                x++;
            }

        }

        return D;

    }

    public static List<Integer> solve1(List<Integer> A, List<Integer> B, List<Integer> C){
        List<Integer> D = new ArrayList<>();
        int x = 0;
        int y = 0;
        int z = 0;


        while(x < A.size() && y < B.size() && z < C.size()){
            int a= A.get(x);
            int b = B.get(y);
            int c = C.get(z);
            if(a == b && b == c){
                D.add(a);
                x++; y++; z++;
            } else if(a == b && c < b){
                z++;
            } else if(b < a){
                y++;
            } else {
                x++;
            }

        }

        return D;
    }


}
