/**
 * Created by Yifeng Zeng on 1/24/17.
 */
/*

Find Peak Element

        There is an integer array which has the following features:

        The numbers in adjacent positions are different.
        A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
        We define a position P is a peek if:

        A[P] > A[P-1] && A[P] > A[P+1]
        Find a peak element in this array. Return the index of the peak.

        Given [1, 2, 1, 3, 4, 5, 7, 6]

        Return index 1 (which is number 2) or 6 (which is number 7)
*/


public class Q75FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length < 3) {
            return -1;
        }

        //A.length has to > 2, so mid > 0 && mid < A.length - 1
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid-1] < A[mid] && A[mid] < A[mid+1]) {
                start = mid;
            } else if (A[mid-1] > A[mid] && A[mid] > A[mid+1]) {
                end = mid;
            } else if (A[mid-1] > A[mid] && A[mid+1] > A[mid]) {//local lowest
                start = mid;
            } else {
                return mid;
            }
        }

        if (A[start] > A[start-1] && A[start] > A[start+1]) {
            return start;
        }
        return end;
    }

    public static void main(String[] args) {
        Q75FindPeakElement A75 = new Q75FindPeakElement();
        int[] nums = {1, 2, 1, 3, 4, 5, 7, 6};
        System.out.println(A75.findPeak(nums));
    }

}
