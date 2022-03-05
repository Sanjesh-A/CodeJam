package RoundA2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Training {
    public static void main() throws IOException {
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());*/

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i< t; i++){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[] S = new int[n];
            for(int j=0; j<n; j++){
                S[j] = sc.nextInt();
            }
            int hours = solve(S,n,p);
            System.out.printf("Case #%d: %s\n", i+1, hours);
        }

    }

    public static int solve(int[] S, int n, int p) {
        //Comparator<ma>
       reverseSort(S,0, n-1);

       int sum = 0;

       for(int i=0; i<p; i++){
           sum += S[i];
       }

       int minSum = p*S[0] - sum;


       for(int i=p; i<n; i++){
           sum = sum - S[p-i];
           sum = sum + S[i];
           int hours =  p*S[p-i+1] - sum;
           if(hours < minSum){
               minSum = hours;

           }
       }

       return minSum;

    }

    public static void reverseSort(int[] S, int low, int high){
        if(low < high){
            int p = partition(S,low, high);
            reverseSort(S,low,p);
            reverseSort(S,p+1, high);
        }
    }

    public static int partition(int[] S, int low, int high){
        int pivot = S[(low + high)/2];
        while(low < high) {
            while(S[low] > pivot) {
                low++;
            }

            while(S[high] < pivot){
                high--;
            }

            if(low < high){
                int temp = S[low];
                S[low] = S[high];
                S[high] = temp;
            }
        }
        return high;


    }

    public void swap(int[] S, int i, int j){
        int temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }


}


