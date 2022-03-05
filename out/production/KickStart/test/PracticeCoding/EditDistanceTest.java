package PracticeCoding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @Test
    void solve() {
    }

    @Test
    void getEditDistance() {
        int ed = EditDistance.getEditDistance("abc", 3, "abd", 3);
        assertEquals(1,ed);

        ed = EditDistance.getEditDistance("abc", 3, "abc", 3);
        assertEquals(0,ed);
    }
}