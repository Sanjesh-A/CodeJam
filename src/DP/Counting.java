package DP;

public class Counting {
    public static final long[][][] cache = new long[1000][100][100];
    public static int cacheHits = 0;
    public static void main() {
        try{
            int n = 5;
            long catalanNumber = F(10, 5, 5);
            System.out.println(catalanNumber);
        }catch ( Exception e){


        }


    }

    public static long F(int n, int x, int y) {
        if(n==0)
            return 0;
        if(x > y)
            return 0;
        if(x == 0)
            return 1;
        if(cache[n][x][y] > 0) {
            cacheHits++;
            return cache[n][x][y];
        }
        long count = F(n-1, x-1, y) + F(n-1, x,y-1);
        cache[n][x][y] = count;

        return count;
    }

}
