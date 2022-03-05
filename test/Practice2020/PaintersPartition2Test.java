package Practice2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaintersPartition2Test {

    @Test
    void paint() {
        PaintersPartition2 pp = new PaintersPartition2();
        //Integer[] A = {1,2,3,4,10,10,2};
        // Integer[] A = { 640, 435, 647, 352, 8, 90, 960, 329, 859 };   , ans=17220
      Integer[] A = {185, 186, 938, 558, 655, 461, 441, 234, 902, 681 }; // ans 18670

        List<Integer> list = Arrays.asList(A);
        ArrayList<Integer> alist = new ArrayList<>(list);
        int time = pp.paint(3,10, alist);
        System.out.println(time);


        Integer[] B = {1,10 }; // ans 50

        List<Integer> list1 = Arrays.asList(B);
        ArrayList<Integer> alist1 = new ArrayList<>(list1);
        time = pp.paint(2,5, alist1);
        System.out.println(time);

        Integer[] C = {1000000,1000000 }; // ans 50

        List<Integer> listC = Arrays.asList(C);
        ArrayList<Integer> alistC = new ArrayList<>(listC);
        time = pp.paint(1,1000000, alistC);
        System.out.println(time);

    }

}