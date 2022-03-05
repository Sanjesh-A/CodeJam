package Practice2020;


import java.util.ArrayList;

public class MaxSum {


    public int solve(ArrayList<Integer> A, int B) {
        return getMaxSum(A, B);
    }

    public int getMaxSum(ArrayList<Integer> A, int B){
        if(A.size()  == B){
            Integer sum = A.stream()
                            .mapToInt(Integer::intValue)
                            .sum();


            return sum;
        }

        return 0;


    }
}