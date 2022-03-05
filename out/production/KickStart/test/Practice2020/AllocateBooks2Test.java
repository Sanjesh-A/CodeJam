package Practice2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AllocateBooks2Test {

    @Test
    void books() {
        AllocateBooks2 ab = new AllocateBooks2();

//        Integer[] A = {73, 58, 30, 72, 44, 78, 23, 9 }; // ans 110
//
//        List<Integer> list = Arrays.asList(A);
//        ArrayList<Integer> alist = new ArrayList<>(list);
//        int minmax = ab.books(alist,5);
//        System.out.println(minmax);

//        Integer[] B = {97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24};
////
//        List<Integer> listB = Arrays.asList(B);
//        ArrayList<Integer> alistB = new ArrayList<>(listB);
//        int minmaxB = ab.books(alistB,26);
//        System.out.println(minmaxB);

        Integer[] C = {12, 34, 67, 90};
        List<Integer> listC = Arrays.asList(C);
        ArrayList<Integer> alistC = new ArrayList<>(listC);
        int minmaxB = ab.books(alistC,2);
        System.out.println(minmaxB);

    }
}