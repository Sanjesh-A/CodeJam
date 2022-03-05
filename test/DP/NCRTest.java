package DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NCRTest {

    @Test
    void nCr() {
        long val = NCR.nCr(5,2);
        System.out.println(NCR.cacheHits);
        assertEquals(10, val);

        val = NCR.nCr(100,2);
        System.out.println(NCR.cacheHits);
        assertEquals(4950, val);
    }
}