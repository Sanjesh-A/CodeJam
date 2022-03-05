package DP;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CountingTest {

    @Test
    void f() {
        long CN = Counting.F(8,4,4);
        System.out.println(Counting.cacheHits);
        assertEquals(14, CN);

        CN = Counting.F(10,5,5);
        System.out.println(Counting.cacheHits);
        assertEquals(42, CN);

        CN = Counting.F(22,11,11);
        System.out.println(Counting.cacheHits);
        assertEquals(58786, CN);

    }

    @Test
    public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");
        for(Integer i : map.keySet()){
            System.out.println(i);
        }
        assertEquals("[1, 2, 3, 4, 5]", map.keySet().toString());
    }

    @Test
    public void givenLinkedHashMap_whenAccessOrderWorks_thenCorrect() {

        LinkedHashMap<Integer, String> map
                = new LinkedHashMap<>(16, .75f, true);
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);

        Set<Integer> keys = map.keySet();
        assertEquals("[1, 2, 3, 4, 5]", keys.toString());

        map.get(4);
        assertEquals("[1, 2, 3, 5, 4]", keys.toString());

        map.get(1);
        assertEquals("[2, 3, 5, 4, 1]", keys.toString());

        map.get(3);
        assertEquals("[2, 5, 4, 1, 3]", keys.toString());
    }

    @Test
    void testStringSwap(){
        String s1 = "abc";
        String s2 = "xyz";

        System.out.println(s1 + " " + s2);
        swap(s1,s2);
        System.out.println(s1 + " " + s2);
        String temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println(s1 + " " + s2);

        int a = 10;
        Integer I1 = a;
        int i = I1;
        System.out.println(i);

       // LinkedList<TaskPair> list = new LinkedList<>();
        Pair[] p = {new Pair(1,2), new Pair(3,4), new Pair(7,9), new Pair(5,6), new Pair(0,1)};

        Comparator<Pair> cmp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {

                return o1.x - o2.x;
            }
        };

        Arrays.sort(p, cmp);
        for(Pair pair : p){
            System.out.println(pair);
        }

    }

    class Pair {
        public int x;
        public int y;


        public  Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
    private void swap(String s1, String s2){
        String temp = s1;
        s1 = new String(s2);
        s2 = new String(temp);
    }

}