/**
 * Created by Yifeng Zeng on 2/1/17.
 */
/*

Closest Number in Sorted Array

        Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.

        Return -1 if there is no element in the array.

        Notice

        There can be duplicate elements in the array, and we can return any of the indices with same value.

        Have you met this question in a real interview? Yes
        Example
        Given [1, 2, 3] and target = 2, return 1.

        Given [1, 4, 6] and target = 3, return 1.

        Given [1, 4, 6] and target = 5, return 1 or 2.

        Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.
*/

public class Q459ClosestNumberinSortedArray {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        } else if (A.length == 1 || A[0] >= target) {
            return 0;
        } else if (A[A.length - 1] <= target) {
            return A.length - 1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        if (target - A[start] < A[end] - target) {
            return start;
        }
        return end;
    }

    public static void main(String[] args) {
        Q459ClosestNumberinSortedArray A459 = new Q459ClosestNumberinSortedArray();
        int[] A = {1, 2, 3};
        int[] B = {1, 4, 6};
        int[] C = {1, 3, 3, 4};
        int[] D = {1, 4, 8, 12, 16, 28, 38};
        System.out.println(A459.closestNumber(A, 2));
        System.out.println(A459.closestNumber(B, 3));
        System.out.println(A459.closestNumber(B, 5));
        System.out.println(A459.closestNumber(C, 2));
        System.out.println(A459.closestNumber(D, 26));
    }
}
