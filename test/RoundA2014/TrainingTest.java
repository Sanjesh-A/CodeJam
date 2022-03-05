package RoundA2014;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class TrainingTest {

    @Test
    void main() {
    }

    @Test
    void solve() {
        int n = 4;
        int p = 3;
        int[] S1 = {3,1,9,100};
        int hours = Training.solve(S1,n,p);
        assertEquals(14,hours);

        n = 6;
        p = 2;
        int[] S2 = {5,5,1,2,3,4};
        hours = Training.solve(S2,n,p);
        assertEquals(0,hours);

        n =5;
        p= 5;
        int[] S3 = {7,7,1,7,7};

        hours = Training.solve(S3,n,p);
        assertEquals(6,hours);

    }

    @Test
    void testChars(){
        char c1 = '0';
        char c2 = '9';
        String s = "";

        System.out.println("c2-c1 = " + (c2 - c1));
        System.out.println ("c1 strcat c2 - c1 = " + ( '(' + s + (c2-c1) +')'));
        if(c2 > c1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}