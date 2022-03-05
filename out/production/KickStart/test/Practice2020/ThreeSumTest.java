package Practice2020;

import org.junit.jupiter.api.Test;

import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void threeSum() {
        Integer[] A = { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };
        ArrayList<Integer> alist = new ArrayList<>(Arrays.asList(A));
   //     Collections.sort(alist);
   //     System.out.println(alist.toString());

        ThreeSum ts = new ThreeSum();
        ArrayList<ArrayList<Integer>> result = ts.threeSum(alist);
        for(ArrayList<Integer> al : result){
            //printList(al);
            System.out.println(al.toString());
        }
// A : [ 2147483647, -2147483648, -2147483648, 0, 1 ]


    }

    @Test
    void test1(){
        ThreeSum ts = new ThreeSum();
        Integer[] B = { 2147483647, -2147483648, -2147483648, 0, 1 };
        ArrayList<Integer> blist = new ArrayList<>(Arrays.asList(B));

        ArrayList<ArrayList<Integer>> resultB = ts.threeSum(blist);
        for(ArrayList<Integer> al : resultB){
            //printList(al);
            System.out.println(al.toString());
        }
    }

    @Test
    void test(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        Integer i = 0-Integer.MIN_VALUE;
        System.out.println(i);
        long l = 2147483648l;
        i = (int)l;
        System.out.println(i);
        if( 1 < 4 && Integer.MIN_VALUE == Integer.MIN_VALUE)
            System.out.println("works");



    }

    private void printList(ArrayList<Integer> al) {
        for(Integer i : al){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Test
    void testString(){
        String s = "zxab";
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        System.out.println(new String(ca));
    }
}