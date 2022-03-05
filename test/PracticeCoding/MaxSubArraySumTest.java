package PracticeCoding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArraySumTest {

    @Test
    void maxSubArraySum11() {
        int[] A = {1,2,3,4};
        int sum = MaxSubArraySum.maxSubArraySum1(A);
        assertEquals(10, sum);

        int[] B = {-1,-2,-3,-4};
        sum = MaxSubArraySum.maxSubArraySum1(B);
        assertEquals(-1, sum);
    }


    @Test
    void maxSubArraySum2() {
        int[] A = {1,2,3,4};
        int sum = MaxSubArraySum.maxSubArraySum2(A, 0 , A.length-1);
        assertEquals(10, sum);


        int[] B = {-1,-2,-3,-4};
        sum = MaxSubArraySum.maxSubArraySum2(B, 0 , B.length-1);
        assertEquals(-1, sum);
    }

    @Test
    void maxArraySumAcrossMid1() {
    }
}