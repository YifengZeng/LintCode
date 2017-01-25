/**
 * Created by Yifeng Zeng on 1/24/17.
 */
/*
Find Minimum in Rotated Sorted Array

        Suppose a sorted array is rotated at some pivot unknown to you beforehand.

        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

        Find the minimum element.

        Given [4, 5, 6, 7, 0, 1, 2] return 0
*/


public class Q159FindMinimuminRotatedSortedArray {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int val = nums[nums.length - 1];
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > val) {
                start = mid;
            } else if (nums[mid] < val) {
                end = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] < nums[end]) {
            return nums[start];
        }
        return nums[end];
    }

    public static void main(String[] args) {
        Q159FindMinimuminRotatedSortedArray A159 = new Q159FindMinimuminRotatedSortedArray();
        int[] nums = {0, 1, 2, 4, 5, 6, 7};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(A159.findMin(nums));
        System.out.println(A159.findMin(nums2));
    }
}
