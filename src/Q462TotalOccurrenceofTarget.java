/**
 * Created by Yifeng Zeng on 2/1/17.
 */
/*

Total Occurrence of Target

        Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.

        Have you met this question in a real interview? Yes
        Example
        Given [1, 3, 3, 4, 5] and target = 3, return 2.

        Given [2, 2, 3, 4, 6] and target = 4, return 1.

        Given [1, 2, 3, 4, 5] and target = 6, return 0.
*/

public class Q462TotalOccurrenceofTarget {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int firstIndex = -1;
        int lastIndex = -2;
        int start = 0;
        int end = A.length - 1;

        //find the first target
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            firstIndex = start;
        } else if (A[end] == target) {
            firstIndex = end;
        }

        //find the last target
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[end] == target) {
            lastIndex = end;
        } else if (A[start] == target) {
            lastIndex = start;
        }

        return lastIndex - firstIndex + 1;
    }

    public static void main(String[] args) {
        Q462TotalOccurrenceofTarget A462 = new Q462TotalOccurrenceofTarget();
        int[] A = {1, 3, 3, 4, 5};
        int[] B = {2, 2, 3, 4, 6};
        int[] C = {1, 2, 3, 4, 5};
        int[] D = {1, 1, 1};
        System.out.println(A462.totalOccurrence(A, 3));
        System.out.println(A462.totalOccurrence(B, 3));
        System.out.println(A462.totalOccurrence(C, 3));
        System.out.println(A462.totalOccurrence(C, 6));
        System.out.println(A462.totalOccurrence(D, 1));

    }
}
