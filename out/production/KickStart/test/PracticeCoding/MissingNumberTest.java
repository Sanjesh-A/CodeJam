package PracticeCoding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    @Test
    void solve() {
        int[] A = {1,2,4,3,4,6};
        MissingNumber.solve(A,6);
    }
}