package Practice2019;
import java.util.Scanner;

public class NumberGuessing {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++){
            long A = sc.nextLong();
            long B = sc.nextLong();
            long N = sc.nextLong();
            boolean done = false;
            A = A + 1;
            while (!done && A <= B && N>0){
                long guess = (A+B)/2;
                System.out.println(guess);
                N--;
                String result = sc.next();
               // System.out.println(result);
                if(result.equals("CORRECT")){
                    break;
                }
                if(result.equals("TOO_SMALL")){
                    A = guess+1;
                } else if(result.equals("TOO_BIG")){
                    B = guess - 1;
                }
                if(result.equals("WRONG_ANSWER")){
                    System.out.println("Incorrect answer. Exiting");
                    System.exit(0);
                }
            }
        }
    }
}
