package PracticeCoding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KSortedArrayIteratorTest {

    @Test
    void next() {

    }

    @Test
    void hasNext() {
    }

    @Test
    void shouldReturnSortedList(){
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3,7,10,12));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4,8,11));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(5,9,13));
        List<List<Integer>> l = new ArrayList<>();
        l.add(l1);
        l.add(l2);
        l.add(l3);

        KSortedArrayIterator<Integer> ksai = new KSortedArrayIterator<>(l);
        while(ksai.hasNext()){
            System.out.println(ksai.next());
        }
    }
}