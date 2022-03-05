package PracticeCoding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeriodicStringTest {

    @Test
    void check() {
        String str = "ababab";
        assertTrue(PeriodicString.check(str));

        str = "aaaaaa";
        assertTrue(PeriodicString.check(str));

        str = "aabbaaaabbaa";
        assertTrue(PeriodicString.check(str));

        str = "aba";
        assertFalse(PeriodicString.check(str));
    }

    @Test
    void rotateString() {
        String str = "abc";
        String rstr = PeriodicString.rotateString(str);
        assertEquals("bca",rstr);

    }
}