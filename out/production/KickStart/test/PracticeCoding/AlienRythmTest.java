package PracticeCoding;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AlienRythmTest {

    @Test
    void solve() {
        String[] input = {"codejam", "jam","HAM","NALAM","HUM","NOLOM"};
        int sum  = AlienRythm.solve(input, 6);
        assertEquals(6, sum);
    }

    @Test
    void solve1() {
        String[] input = { "AIIIIA", "BIIIIA", "CIIIIB", "DIIIIB", "EIIII", "FIIII", "GIIII", "HIIII"};
        int sum  = AlienRythm.solve(input, 8);
        assertEquals(8, sum);
    }

    @Test
    void solve2() {
        String[] input = { "ABCDEFG", "BCDEFG", "CDEFG", "DEFG", "EFG", "FG", "XYZ", "YZ", "MNOP", "QRST"};
        int sum  = AlienRythm.solve(input, 10);
        assertEquals(8, sum);
    }

    @Test
    void solve3() {
        String[] input = { "ABCDEFG", "BCDEFG", "CDEFG", "AAFG", "BAFG", "CAFG", "XYZ", "YZ", "MNOP", "QRST"};
        int sum  = AlienRythm.solve(input, 10);
        assertEquals(8, sum);
    }

    @Test
    void testLoop(){
        int i = 5;
        for(; i < 10; i++){
            System.out.println(i);
        }
    }

}