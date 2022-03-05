package Practice2020;

import java.util.ArrayList;

public class Rotate2D {

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for(int j=0; j<(n+1)/2; j++){
            for(int i=j; i < n-1-j; i++){
                int t= a.get(i).get(j);
                a.get(i).set(j, a.get(n-1-j).get(i));
                a.get(n-1-j).set(i,a.get(n-1-i).get(n-1-j));
                a.get(n-1-i).set((n-1-j), a.get(j).get(n-1-i));
                a.get(j).set((n-1-i),t);
            }
        }
        for(ArrayList<Integer> alist : a){
            for(Integer i : alist){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
