package TwoSigma2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void longestChain() {
        List<String> words = new ArrayList<>( Arrays.asList("a", "b", "ba", "cab", "acdb", "asdghg"));
        int len = Result.longestChain(words);
        assertEquals(4,len);
    }

    @Test
    void getChainLength() {
    }
}