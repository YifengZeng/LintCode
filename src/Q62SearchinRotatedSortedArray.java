/**
 * Created by Yifeng Zeng on 1/24/17.
 */
/*

Search in Rotated Sorted Array

        Suppose a sorted array is rotated at some pivot unknown to you beforehand.

        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

        You are given a target value to search. If found in the array return its index, otherwise return -1.

        You may assume no duplicate exists in the array.

        Example
        For [4, 5, 1, 2, 3] and target=1, return 2.

        For [4, 5, 1, 2, 3] and target=0, return -1.
*/

public class Q62SearchinRotatedSortedArray {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            /*if (A[start] < target || target < A[mid]) {
                end = mid;
            } else if (A[mid] < target || target < A[end]) {
                start = mid;
            }*///wrong answer, 6, 8, 9, 1, 3, 5 : 5 return -1
            /*if (A[start] < target) {
                if (target < A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {//A[start] > target
                if (target < A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }*///wrong answer, 6, 8, 9, 1, 3, 5 : 5 return -1
            if (A[start] > A[mid]) {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else { //A[start] < A[mid]
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {

        Q62SearchinRotatedSortedArray A62 = new Q62SearchinRotatedSortedArray();
        int[] nums = {4, 5, 1, 2, 3};
        System.out.println(A62.search(nums, 1));
        System.out.println(A62.search(nums, 0));
        int[] nums2 = {6, 8, 9, 1, 3, 5};
        System.out.println(A62.search(nums2, 5));
        int[] nums3 = {4, 5, 6, 2, 3};
        System.out.println(A62.search(nums3, 6));
    }
}
