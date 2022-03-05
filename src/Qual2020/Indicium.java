package Qual2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Indicium {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            int trace = sc.nextInt();
            int[][] a = new int[n][n];
            int remainder = trace;

            int t = trace - n - 1;
            //find x,y,z: xn+y1+z=trace and x+y=n-1.
            int x=0;
            if(t > n){
                x = t / n;
                remainder = t % n;
            }
            int y=0;
            t = remainder+n-1;
            if(n-x-1 > 0){
                y= n-x-1;

            }
            int z = t - y;

            a[n-1][n-1]=x;
            for(int j=0; j<y; j++){
                a[j][j] = 1;
            }
            for(int j=y; j<n-1; j++ ){
                a[j][j] = n;
            }






            System.out.println("Case #"+ (i+1) + ": "  );
        }
    }
}
