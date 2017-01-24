/**
 * Created by Yifeng Zeng on 1/22/17.
 */
/*

 Last Position of Target
         Find the last position of a target number in a sorted array. Return -1 if target does not exist.

         Given [1, 2, 2, 4, 5, 5].

         For target = 2, return 2.

         For target = 5, return 5.

         For target = 6, return -1.
*/

public class Q458LastPositionofTarget {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = (end - start) / 2 + start;

        while (start + 1 < end) {
            if (nums[mid] > target) {
                end = mid;
            }
            if (nums[mid] == target) {
                start = mid;
            }
            if (nums[mid] < target) {
                start = mid;
            }
            mid = (end - start) / 2 + start;
        }

        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {

        Q458LastPositionofTarget res = new Q458LastPositionofTarget();
        int[] nums = {1, 2, 2, 4, 5, 5};

        System.out.println(res.lastPosition(nums, 2));
        System.out.println(res.lastPosition(nums, 5));
        System.out.println(res.lastPosition(nums, 6));
    }
}