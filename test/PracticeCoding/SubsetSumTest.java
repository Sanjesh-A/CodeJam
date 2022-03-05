package PracticeCoding;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SubsetSumTest {

    @Test
    void getCountOfSubsets() {
        SubsetSum ss = new SubsetSum();
        int[] a = {1,2,3,4,5,6,10};
        int count = ss.getCountOfSubsets(a, 0, 16);
        System.out.println(ss.cacheHits);
        assertEquals(7,count);

        SubsetSum ss1 = new SubsetSum();
        count = ss1.getCountOfSubsets(a, 0, 0);
        System.out.println(ss1.cacheHits);
        assertEquals(1,count);
    }


}