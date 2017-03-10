/**
 * Created by Yifeng Zeng on 3/9/17.
 */

/*
Maximum Number in Mountain Sequence
        Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

        Have you met this question in a real interview? Yes
                Example
        Given nums = [1, 2, 4, 8, 6, 3] return 8
        Given nums = [10, 9, 8, 7], return 10

*/
public class Q585MaximumNumberinMountainSequence {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length;

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}
