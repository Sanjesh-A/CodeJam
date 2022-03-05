package DP;

public class NCR {
    public static final long[][] cache = new long[1000][1000];
    public static int cacheHits = 0;
    public static void main() {
        int n = 5;
        int r = 2;
        long result = nCr(n,r);
        System.out.println(result);
    }

    public static long nCr(int n, int r) {


        if(r==0)
            return 1;

        if(n==0)
            return 0;


        if(cache[n][r] > 0){
            cacheHits++;
            return cache[n][r];
        }

        long val = nCr(n-1, r-1) + nCr(n-1,r);
        cache[n][r] = val;
        return val;
    }

}
