package Practice2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllocateBooksTest {

    @Test
    void books() {

        AllocateBooks ab = new AllocateBooks();

        Integer[] A = {73, 58, 30, 72, 44, 78, 23, 9 }; // ans 110

        List<Integer> list = Arrays.asList(A);
        ArrayList<Integer> alist = new ArrayList<>(list);
        int minmax = ab.books(alist,5);
        System.out.println(minmax);
    }

}