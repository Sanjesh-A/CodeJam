package Practice2020;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ArrayPerm {


    void solve(int n){
        int[] a = new int[2*n];

        int k=0;
        for(int i=1; i<=n; i++){
            a[k++] = i;
            a[k++] = i;
        }

        for(int i=0; i<2*n; i++){
            a[i] = -1;
        }

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0; i<2*n; i++){
            set.add(i);
        }
        boolean success = false;
        for(int i=0; i<n-1; i++) {
            a[i] = n;
            int j = i + n + 1;
            a[j] = n;
            if(arrange(a, n-1)){
                success = true;
                break;
            };
            a[i] = -1;
            a[j] = -1;
        }

        if(success){
            System.out.println();
            for(int i=0;i<2*n; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private boolean arrange(int[] a, int n) {
        if(n == 0){
            return true;
        }
        int i = -1;
        while((i=findnexti(a,i))>-1){
            int k = i+n+1;
            if(k < a.length && a[k]==-1) {
                a[i] = n;
                a[k] = n;
                if (arrange(a, n - 1)) {
                    return true;
                }
                a[i]=-1;
                a[k]=-1;
            }



        }
        return false;
    }

    private int findnexti(int[] a, int i) {
        int size = a.length;
        for(int j=i+1; j<size;j++){
            if(a[j]== -1)
                return j;
        }
        return -1;
    }
}
