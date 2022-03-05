package Practice2020;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Rotate2DTest {

    @Test
    void rotate() {
//        int[] A = {0,1,2,3};
//        List<Integer> list = Arrays.asList(0,1,2,3);
//        ArrayList<Integer> alist = new ArrayList<>(list);
//        for(int i=0; i<alist.size(); i++){
//            System.out.println(alist.get(i));
//            alist.set(i, 10+i);
//            System.out.println(alist.get(i));
//
//        }
//
//
//        for(int i=0; i<alist.size(); i++){
//            System.out.println(alist.get(i));
//
//        }

        Rotate2D r2d = new Rotate2D();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(0,1,2,3);
        ArrayList<Integer> alist1 = new ArrayList<>(list1);
        List<Integer> list2 = Arrays.asList(4,5,6,7);
        ArrayList<Integer> alist2 = new ArrayList<>(list2);
        List<Integer> list3 = Arrays.asList(8,9,10,11);
        ArrayList<Integer> alist3 = new ArrayList<>(list3);
        List<Integer> list4 = Arrays.asList(12,13,14,15);
        ArrayList<Integer> alist4 = new ArrayList<>(list4);
        a.add(alist1);
        a.add(alist2);
        a.add(alist3);
        a.add(alist4);
        r2d.rotate(a);

    }

    @Test
    void testSimple() {
        Rotate2D r2d = new Rotate2D();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(0,1);
        ArrayList<Integer> alist1 = new ArrayList<>(list1);
        List<Integer> list2 = Arrays.asList(2,3);
        ArrayList<Integer> alist2 = new ArrayList<>(list2);
        a.add(alist1);
        a.add(alist2);
        r2d.rotate(a);
    }

    @Test
    void testLambdaStreams(){
        Integer[] A = {10,2,3,4,5};
        Optional<Integer> max = Arrays.stream(A).max(Integer::compareTo);
        int t=0;
        t = max.isPresent()? max.get() : -1;
        System.out.println(t);
        Integer[] B =  Arrays.stream(A)
                    .filter(i -> i>2)
                    .map(i -> i+10 )
                    .toArray(Integer[]::new);
        for(int i: B){
            System.out.println(i);
        }

        Integer[] C = Arrays.stream(A)
                .sorted((i,j)->j-i)
                .toArray(Integer[]::new);



        for(int i: C){
            System.out.println(i);
        }

        Arrays.stream(A)
                .filter(i -> i>2)
                .map(i -> i+10 );
        // Arrays.sort(A, (i,j)->j-i);
    }
}