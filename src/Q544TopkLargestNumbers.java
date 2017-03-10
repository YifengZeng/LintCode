/**
 * Created by Yifeng Zeng on 2/8/17.
 */
/*

Top k Largest Numbers

        Given an integer array, find the top k largest numbers in it.

        Have you met this question in a real interview? Yes
        Example
        Given [3,10,1000,-99,4,100] and k = 3.
        Return [1000, 100, 10].
*/

import java.util.PriorityQueue;
import java.util.Arrays;
//import java.util.ArrayUtils;

public class Q544TopkLargestNumbers {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        if (nums.length <= k) {
            Arrays.sort(nums);
            //ArrayUtils.reverse(nums);
            return nums;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek().intValue()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().intValue();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 1000, -99, 4, 100};
        int k = 3;
        Q544TopkLargestNumbers a544 = new Q544TopkLargestNumbers();
        int[] result = a544.topk(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
