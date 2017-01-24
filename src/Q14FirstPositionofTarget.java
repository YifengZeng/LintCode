/**
 * Created by Yifeng Zeng on 1/22/17.
 */
/*

First Position of Target
        For a given sorted array (ascending order) and a target number, find
        the first index of this number in O(log n) time complexity.

        If the target number does not exist in the array, return -1.

        If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
*/

class Q14FirstPositionofTarget {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = (end - start) / 2 + start;
        while (start + 1 < end) {

            if (nums[mid] < target) {
                start = mid;
            }
            if (nums[mid] == target) {
                end = mid;
            }
            if (nums[mid] > target) {
                end = mid;
            }
            mid = (end - start) / 2 + start;
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {

        Q14FirstPositionofTarget A14 = new Q14FirstPositionofTarget();
        int[] array = {1, 2, 3, 3, 4, 5, 10};
        int target = 1;
        System.out.println(A14.binarySearch(array, 1));
        System.out.println(A14.binarySearch(array, 3));
        System.out.println(A14.binarySearch(array, 6));



    }
}
