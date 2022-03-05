package Practice2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Parcel {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] grid = new int[r][c];
            Set<Pair> off = new HashSet<>();
            for(int j=0; j<r; j++){
                String row = sc.next();
                for(int k = 0; k<c; k++) {
                    grid[j][k] = row.charAt(k) - '0';
                    if(grid[j][k] == 1)
                        off.add(new Pair(j,k));
                }
            }
            int deliveryTime = getDeliveryTime(r,c,grid,off);
            System.out.println("Case #"+ (i+1) + ": " + deliveryTime);
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int getDeliveryTime(int r, int c, int[][] grid, Set<Pair> off)
    {
        int[][] gridDist = new int[r][c];
        int maxDist = 0;
        int maxR = 0;
        int maxC = 0;
        for(int i =0; i<r; i++){
            for(int j=0; j<c; j++){
                int dist = getMinDist(i,j, off);
                gridDist[i][j] = dist;
                if(maxDist < dist){
                    maxDist = dist;
                    maxR = i;
                    maxC = j;
                }
            }
        }

        int newMaxDist = 0;
        for(int i = 0; i<r; i++){
            for(int j = 0; j< c; j++){
                int dist = Math.min(gridDist[i][j], Math.abs(maxR-i) + Math.abs(maxC - j));
                if(newMaxDist < dist)
                    newMaxDist = dist;
            }
        }

        return newMaxDist;
    }

    static int getMinDist(int i, int j, Set<Pair> off){
        int minDist = Integer.MAX_VALUE;
        for(Pair p : off){
            int dist = Math.abs(p.x-i) + Math.abs(p.y - j);
            if(minDist > dist)
                minDist = dist;
        }
        return minDist;
    }

}
