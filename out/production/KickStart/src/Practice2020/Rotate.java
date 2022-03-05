package Practice2020;

public class Rotate {

    public int[] rotate(int[] A, int n){
        int pos = 0;
        int val = A[pos];
        int initPos = 0;
        int count = 0;
        while(count<A.length){
            int npos = (pos+n)%n;
            int temp = A[npos];
            A[npos] = val;
            val = temp;
            pos = npos;
            count++;
            if(npos == initPos){
                initPos++;
                pos = initPos;
                val = A[pos];
            }


        }

        return A;

    }
}
