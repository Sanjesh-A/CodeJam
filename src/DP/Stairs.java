package DP;

import java.util.Scanner;

public class Stairs {
    public static final long[][] Cache = new long[1000][1000];
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int numOfBlocks = sc.nextInt();
        long total = getNumberOfWaysToBuildStaircase(0,numOfBlocks);
        System.out.println(total - 1);
    }

    public static long getNumberOfWaysToBuildStaircase(int heightOfLastStair, int remainingBlocks) {
        if(remainingBlocks == 0)
            return 1;

        if(remainingBlocks < 0)
            return 0;

        if(Cache[heightOfLastStair][remainingBlocks] != 0){
            return Cache[heightOfLastStair][remainingBlocks];
        }

        if(heightOfLastStair == 0){
            long result = getNumberOfWaysToBuildStaircase(1,remainingBlocks -1);
            Cache[heightOfLastStair][remainingBlocks] = result;
            return result;
        } else {
            long result =  getNumberOfWaysToBuildStaircase(heightOfLastStair + 1, remainingBlocks -1)
                    + getNumberOfWaysToBuildStaircase(heightOfLastStair+1, remainingBlocks - heightOfLastStair -1);
            Cache[heightOfLastStair][remainingBlocks] = result;
            return result;
        }
    }
}
