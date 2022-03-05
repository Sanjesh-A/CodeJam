package PracticeCoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Pylon {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            boolean[][] visited = new boolean[R+1][C+1];
            int[] visitedOrder = new int[R*C];
            boolean solved = false;
            for(int r = 0; r < R && !solved; r++){
                for (int c =0; c < C && !solved; c++){
                    visited[r][c] = true;
                    solved =  solve(R, C, visited, visitedOrder);

                }
            }
           // System.out.println("Case #"+ (i+1) + ": " );
        }
    }

    public static boolean solve(int r, int c, boolean[][] visited, int[] visitedOrder) {

        return false;
    }

}
