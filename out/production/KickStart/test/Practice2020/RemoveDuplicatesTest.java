package Practice2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    void removeDuplicates1() {
    }

    @Test
    void removeDuplicates() {

        Integer[] A= {5000, 5000, 5000 };
        ArrayList<Integer> alist = new ArrayList<>(Arrays.asList(A));
        RemoveDuplicates rd = new RemoveDuplicates();
        int result = rd.removeDuplicates(alist);
        System.out.println(result);
        System.out.println(alist);

    }
}