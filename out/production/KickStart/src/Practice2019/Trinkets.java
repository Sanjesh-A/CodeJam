package Practice2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Trinkets {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] trinket = new int[n];
            for (int j = 0; j < n; j++) {
                trinket[i]= sc.nextInt();
            }
            int max = getMaxCount(trinket, n, s, 0, n-1);
            System.out.println("Case #"+ (i+1) + ": " + max);

        }
    }

    static int getMaxCount(int[] trinket, int n, int s, int low,  int high){

        if(low == high){
            return 1;
        }

        int mid = (low + high)/2;
        int c1 = getMaxCount(trinket, n, s, low, mid);
        int c2 = getMaxCount(trinket, n, s, mid+1, high);
        int c3 = getMaxCountCrossingSubArrays(trinket, n, s, low, mid, high);

        return Math.max(Math.max(c1, c2), c3);

    }


    static int getMaxCountCrossingSubArrays(int[] trinket, int n, int s, int low, int mid, int high)
    {

        HashMap<Integer, Integer> dups = new HashMap<>();

        int maxSum = 0;
        int sum = 0;

        int i = mid;
        int j = mid +1;
        boolean left = true;

        while(i >= low && j <=high){
            int t;
            if(left)
                t = trinket[i--];
		    else
                t = trinket[j++];

            if(dups.containsKey(t)){
                int c = dups.get(t);
                dups.put(t, c+1);
                if(c == s)
                    sum -= c;
            } else {
                dups.put(t,1);
                sum++;
                if(sum > maxSum)
                    maxSum = sum;
            }

            left = !left;

        }

        return maxSum;

    }



}
