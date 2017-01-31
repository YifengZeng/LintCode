/**
 * Created by Yifeng Zeng on 1/26/17.
 */
/*

Subsets II

        Given a list of numbers that may has duplicate numbers, return all possible subsets

        Notice

        Each element in a subset must be in non-descending order.
        The ordering between two subsets is free.
        The solution set must not contain duplicate subsets.
        Have you met this question in a real interview? Yes
        Example
        If S = [1,2,2], a solution is:

        [
        [2],
        [1],
        [1,2,2],
        [2,2],
        [1,2],
        []
        ]
*/
import java.util.ArrayList;
import java.util.Arrays;

public class Q18SubsetsII {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);

        ArrayList<Integer> subset = new ArrayList<>();
        dfsHelper(0, nums, subset, results);

        return results;
    }

    private void dfsHelper(int index,
                           int[] nums,
                           ArrayList<Integer> subset,
                           ArrayList<ArrayList<Integer>> results) {
        //deep copy
        results.add(new ArrayList<Integer>(subset));

        for (int i = index; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > index) {
                continue;
            }
            subset.add(nums[i]);
            dfsHelper(i + 1, nums, subset, results);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q18SubsetsII A18 = new Q18SubsetsII();
        int[] nums = {1, 2, 2};
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result = A18.subsetsWithDup(nums);
        for (ArrayList<Integer> subset : result) {
            for (Integer num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
