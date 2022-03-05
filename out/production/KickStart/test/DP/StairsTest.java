package RoundA2014;

import DP.Stairs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StairsTest {



    @Test
    public void getNumberOfWaysToBuildStaircase() {
        int nStates = 7;
        int[] state = new int[nStates];


 //       long total =Stairs.getNumberOfWaysToBuildStaircase(0,212);
 //       assertEquals(995645335,total);

//        long total = Stairs.getNumberOfWaysToBuildStaircase(0,1);
//        assertEquals(1,total);

        long total = Stairs.getNumberOfWaysToBuildStaircase(0,3);
        assertEquals(2,total);

        total = Stairs.getNumberOfWaysToBuildStaircase(0,5);
        assertEquals(3,total);

        total = Stairs.getNumberOfWaysToBuildStaircase(0,6);
        assertEquals(4,total);

        total =Stairs.getNumberOfWaysToBuildStaircase(0,25);
        assertEquals(141 + 1,total);

        total =Stairs.getNumberOfWaysToBuildStaircase(0,500);
        assertEquals(732986521245023L + 1L,total);

        total =Stairs.getNumberOfWaysToBuildStaircase(0,212);
        assertEquals(995645335 + 1,total);


    }


}
