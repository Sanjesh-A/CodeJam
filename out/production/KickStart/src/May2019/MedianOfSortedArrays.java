package May2019;

public class MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mStart = 0;
        int mEnd = m - 1;
        int nStart = 0;
        int nEnd = n - 1;
        int mIndex = 0;
        int nIndex = 0;

        while( mStart <= mEnd && nStart <= nEnd && ((mIndex+1+nIndex+1) != (m+n)/2)){
            mIndex = (mStart + mEnd)/2;
           // nIndex = findPosition(nums2, nStart, nEnd, nums1[mIndex]);
            if(mIndex+nIndex > (m+n)/2){
                mEnd = mIndex - 1;
                nEnd = nIndex - 1;
            } else {
                mStart = mIndex + 1;
                nStart = nIndex + 1;
            }
        }

        
//        if((mIndex+1+nIndex+1) == (m+n)/2){
//            if((m+n) % 2  == 0)
//        }
        return 1.0;
    }

//    //binary search to return index of largest element less than key
//    private int findPosition(int[] nums2, int nStart, int nEnd, int key) {
//
//    }

    private boolean outOfBounds(int index, int size) {
        return  (index >= 0) && (index < size);
    }

}