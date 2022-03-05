package Practice2020;

import java.util.ArrayList;

public class AllocateBooks2 {


    public int books(ArrayList<Integer> A, int B) {
        long high = 0;
        long low = 0;
        for(Integer i : A){
            high += i;
            if(i > low)
                low = i;
        }

        long[] sum = new long[A.size()];
        int students = 0;

        long minmax = high;
        boolean possible = false;

        int n = A.size();

        while(low <= high){
            long mid = (low+high)/2;
            long tempSum = 0;
            int remainingStudents = B;
            students = 0;
            for(int i=0; i<sum.length; i++)
                sum[i]=0;

            int booksRemaining = n;
            for(int i=0; i<n; i++){
                booksRemaining--;
                if( n-i  >= remainingStudents ){
                    int val = A.get(i);
                    if(tempSum + val > mid ){
                        sum[students] = tempSum;
                        students++;
                        tempSum = val;
                        remainingStudents--;
                    } else {
                        tempSum += val;
                    }
                } else {
                    if(i>0){
                        sum[students] = tempSum;
                        students++;
                        remainingStudents--;
                        tempSum = 0;
                    }
                    sum[students++] = A.get(i);
                    remainingStudents--;
                }
            }
            if(tempSum >0){
                sum[students++] = tempSum;
            }


            if(students == B){
                possible = true;
                long max = 0;
                for(int i=0; i<students; i++){
                    if(sum[i] > max)
                        max = sum[i];
                }
                if(max < minmax)
                    minmax = max;
            }

            if(students <=B){
                high = mid -1;
            } else {
                low = mid +1;
            }
        }



        if(possible)
            return (int) minmax;
        else
            return -1;

    }
}
