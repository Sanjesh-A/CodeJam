package Practice2020;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTreeMapTest {

    @Test
    void order() {

        Integer[] A = {5, 3, 2, 6, 1, 4};
        List<Integer> list = Arrays.asList(A);
        ArrayList<Integer> alist = new ArrayList<>(list);


        Integer[] B = {0, 1, 2, 0, 3, 2};
        List<Integer> listB = Arrays.asList(B);
        ArrayList<Integer> blist = new ArrayList<>(listB);

        TestTreeMap tm = new TestTreeMap();
        ArrayList<Integer> result = tm.order(alist,blist);
        System.out.println(result.toString());
    }
}