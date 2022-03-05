package PracticeCoding;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntersectionTest {

    @Test
    void solve() {
        int[] A = {8,10,12,14,16};
        int[] B = {8,10,12,14,16};
        int[] C = {8,10,12,14,16};
        int[] D = ArrayIntersection.solve(A,B,C,5);
        assertArrayEquals(A, D);
    }

    @Test
    void solve1() {
        List<Integer> A =Arrays.asList(10,12,16);
        List<Integer> B =Arrays.asList(8,10,12,14,16);
        List<Integer> C =Arrays.asList(8,10,12,14,16);

        List<Integer> D = ArrayIntersection.solve1(A,B,C);
        assertArrayEquals(A.toArray(), D.toArray());
    }
}