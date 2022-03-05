package Practice2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NgramTest {

    @Test
    void getMatchingCount() {
        Ngram ngram = new Ngram();
        String str1 = "1 2 3 4 5";
        String str2 = "3 4 1 2";
        int count = ngram.getMatchingCount(str1, str2, 2);
        assertEquals(2, count);
    }
}