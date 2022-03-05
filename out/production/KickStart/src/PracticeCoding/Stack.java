package PracticeCoding;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private int[] stack;
    private int size;
    private static final int INITIAL_SIZE = 10;
    private int tos = 0;

    public Stack(int size){
        this.size = size;
        stack = new int[size];

    }

    public Stack(){
        size = INITIAL_SIZE;
        stack = new int[size];
    }

    public void push(int val){
        checkCapacity();
        stack[tos++] = val;
    }

    public int pop(){
        if(!isEmpty()){
            return stack[--tos];
        }
        throw new EmptyStackException();
    }

    public boolean isEmpty(){
        return (tos == 0);
    }

    private void checkCapacity(){
        if(tos == size){
            size *= 2 ;
            stack = Arrays.copyOf(stack, size );
        }
    }
}
