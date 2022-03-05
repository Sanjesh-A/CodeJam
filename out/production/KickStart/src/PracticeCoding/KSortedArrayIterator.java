package PracticeCoding;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedArrayIterator<T>  {



    private class HeapObject<T> implements  Comparable {
        T t;
        Iterator iterator;

        public HeapObject(T t, Iterator<T> i) {
            this.t= t;
            iterator = i;
        }

        @Override
        public int compareTo(Object o) {
            HeapObject<T> temp = (HeapObject<T>) o;
            Comparable<? super T> a = (Comparable<? super T>) t;
            return a.compareTo(temp.t);

        }


    }

    private final List<List<T>> arrays;
    PriorityQueue<HeapObject> minHeap;


    KSortedArrayIterator(List<List<T>> arrays){
        this.arrays = arrays;
        minHeap = new PriorityQueue<>(arrays.size());
        initialize(minHeap);
    }

    private void initialize(PriorityQueue<HeapObject> minHeap) {
        for(int i = 0; i<arrays.size(); i++){
            Iterator<T> iterator = arrays.get(i).iterator();
            if(iterator.hasNext()){
                HeapObject ho = new HeapObject(iterator.next(), iterator);
                minHeap.add(ho);
            }
        }
    }

    T next(){
        HeapObject<T> heapObject = minHeap.remove();
        if(heapObject.iterator.hasNext()){
            HeapObject<T> newObj = new HeapObject<>( heapObject.iterator.next(),heapObject.iterator);
            minHeap.add(newObj);
        }
        return heapObject.t;
    }

    boolean hasNext(){
        return !minHeap.isEmpty();
    }



}
