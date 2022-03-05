package Practice2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Coaching {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[] S = new int[n];
            for(int j=0; j<n; j++){
                S[j] = sc.nextInt();
            }
            int mc = minCoachingTime(n,p,S);
            System.out.println("Case #"+ (i+1) + ": " + mc);
        }
    }

    public static int minCoachingTime(int N, int P, int[] S)
    {

        reverseSort(S);

        int sum = 0;

        for(int i=0; i<P; i++){
            sum +=  S[0] - S[i];
        }

        int end = P;
        int minSum = sum;
        int maxSkill = S[0];
        for(int i = 1; i< N && end < N; i++,end++){
            sum = sum - (maxSkill - S[i-1]) + (S[i] - S[end]);
            if(maxSkill > S[i]){
                int diff = maxSkill - S[i];
                sum = sum - (diff * (P-1));
                maxSkill = S[i];
            }


            if(minSum > sum)
                minSum = sum;
        }

        return minSum;
    }

    private static void reverseSort(int[] S)
    {
        mergeSort(S, 0, S.length -1);

    }

    private static void mergeSort(int[] S, int start, int end){

        if(start < end){
            int midpoint = (start + end)/2;
            mergeSort(S, start, midpoint);
            mergeSort(S,midpoint+1, end);
            merge(S, start, end);
        }

    }

    private static void merge(int[] S, int start, int end){
        int midpoint = (start + end)/2;
        int i = start;
        int j = midpoint+1;

        int[] T = new int[end-start+1];
        int k = 0;
        while( i <= midpoint  && j<=end){
            if(S[i] >= S[j]){
                T[k++] = S[i++];
            } else {
                T[k++] = S[j++];
            }

        }

        while(i <= midpoint){
            T[k++] = S[i++];
        }

        while(j<=end){
            T[k++] = S[j++];
        }

        for(int x=start; x<=end; x++){
            S[x] = T[x-start];
        }

    }
}