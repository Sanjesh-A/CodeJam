package PracticeCoding;

import java.util.Scanner;


public class JamCoins {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            findAB(n,i);
        }
    }

    public static void findAB(int n, int i) {
        int placeval = 1;
        int y = n;
        int a = 0;
        int b = 0;
        while(y > 0) {
            int x = y % 10;
            if(x == 4){
                a = a + (placeval*3);
                b = b + placeval;
            } else {
                a = a + (placeval * x);
            }
            y = y / 10;
            placeval *= 10;
        }
        System.out.println("Case #"+ (i+1) + ": " + a + " " + b);
    }
}
