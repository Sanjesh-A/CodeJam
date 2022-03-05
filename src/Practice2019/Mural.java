import java.lang.reflect.Array;
import java.util.Scanner;

public class Mural {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int nTestCases = sc.nextInt();
        int[] A = new int[5000000];
        long[] arraySum = new long[2500000];

        for (int i = 0; i < nTestCases; i++) {
            int N = sc.nextInt();
            String bs = sc.next();
            int index = 0;
            for (char c: bs.toCharArray()) {
                A[index++] = c - '0';
            }

            int nsec = N/2 + (N%2);

            int sp1 = 0;
            int ep1 = 0;
            int sp2 = nsec;
            int ep2 = nsec;
            arraySum[0] = getSum(A,0, nsec -1);
            long maxSum = arraySum[0];
            for(int j = 1; j < nsec; j++){
                arraySum[j] = arraySum[j-1] - A[j-1] + A[nsec+j-1];
                if(arraySum[j] > maxSum)
                    maxSum = arraySum[j];
            }

            /*while(ep2 < N){
                int t = 0;
                int s1 = getSum(A, sp1,ep1);
                int s2 = getSum(A,sp2,ep2);
                if(s2 > s1){
                    sp1 = ep1+1;
                    ep1 = ep1 +1;
                    sp2 = ep2+1;
                    ep2 = ep2 +1;
                } else {
                    ep1++;
                    ep2++;
                }
            }*/
            System.out.println("Case #"+ (i+1) + ": " + maxSum);

        }
    }

    private static int getSum(int[] a, int start, int end) {
        int sum = 0;
        for(int i = start; i<=end; i++){
            sum += a[i];
        }
        return sum;
    }
}
