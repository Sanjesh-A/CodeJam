package PracticeCoding;

public class MaxSubArraySum {

    public static int maxSubArraySum1(int[] A){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int startIndex = 0;
        int endIndex = 0;
        for(int i =0; i < A.length; i++ ){
            sum = sum + A[i];
            if(sum > maxSum){
                maxSum = sum;
                maxStartIndex = startIndex;
                maxEndIndex = i;
            }
            if(sum < 0){
                sum = 0;
                startIndex = i+1;
            }
        }

        return maxSum;
    }

    public static int maxSubArraySum2(int[] A, int startIndex, int endIndex){

        if(startIndex == endIndex){
            return A[startIndex];
        }
        int mid = (startIndex+endIndex)/2;
        return Math.max ( Math.max ( maxSubArraySum2(A, startIndex, mid), maxArraySumAcrossMid(A,startIndex, mid, endIndex)),
                          maxSubArraySum2(A,mid+1, endIndex));
    }

    public static int maxArraySumAcrossMid(int[] A, int startIndex, int mid, int endIndex) {

/*        if(startIndex == endIndex)
            return A[startIndex];*/

        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int i = mid;
        while(i>=startIndex){
            sum += A[i];
            if(sum > leftSum)
                leftSum = sum;

            if(sum <= 0)
                break;

            i--;

        }

        sum =0;
        int rightSum = Integer.MIN_VALUE;
        i= mid+1;
        while(i <=endIndex){
            sum +=  A[i];
            if(sum > rightSum)
                rightSum = sum;

            if(sum <= 0)
                break;

            i++;
        }

        return leftSum + rightSum;
    }
}
