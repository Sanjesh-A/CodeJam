package DP;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;


public class DebutAlbum {

    public static final long[][] Cache = new long[2][100000];
    public static final long M = 1000000007;
    private int x;
    private int y;



   /* public static void main(String[] args) {


        // Using BufferedReader class to take input
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
       // int t = Integer.parseInt(br.readLine());

       // Scanner sc = new Scanner(System.in);
        //int numOfBlocks = sc.nextInt();
        int n = 7000;
        int a = 30;
        int b = 30;
        long total = getNumberOfWaysToOrderSongs(n,a,b);
        System.out.println(total);
    }
*/
    public static long getNumberOfWaysToOrderSongs(int n, int a, int b) {
        return (FS1(n,a,b) + FS2(n,a,b)) % M;

    }

    public static long FS2(int n, int a, int b) {
        if(Cache[1][n] != 0){
            return Cache[1][n];
        }
        if(n==1)
        {
            return 1;
        }

        long sum = 0;
        for(int i = 1; i <= b && i<n; i++){
            sum += FS1(n-i, a, b);
                sum = sum % M;
        }
        Cache[1][n] = sum;
        return sum;
    }

    public static long FS1(int n, int a, int b) {
        if(Cache[0][n] != 0){
            return Cache[0][n];
        }
        if(n==1)
        {
            return 1;
        }
        long sum = 0;
        for(int i = 1; i <= a && i<n; i++){
            sum += FS2(n-i, a, b);
                sum = sum % M;
        }
        Cache[0][n] = sum;
        return sum;
    }


}
