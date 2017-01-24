/**
 * Created by Yifeng Zeng on 1/22/17.
 */
import java.util.ArrayList;
import java.util.Arrays;
/*
Subsets

Given a set of distinct integers, return all possible subsets.

        If S = [1,2,3], a solution is:

        [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
        ]*/
class Q17Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        dfsHelper(0, nums, new ArrayList<Integer>(), results);
        return results;
    }

    //Add the the all the combination subsets starting from index
    private void dfsHelper(int index,
                           int[] nums,
                           ArrayList<Integer> subset,
                           ArrayList<ArrayList<Integer>> results) {
        results.add(new ArrayList<Integer>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            dfsHelper(i + 1, nums, subset, results);
            subset.remove(subset.size() - 1);
        }
    }


    public static void main(String[] args) {
        Q17Subsets A17 = new Q17Subsets();
        int[] nums = {1,3,2};
        ArrayList<ArrayList<Integer>> A17Result = new ArrayList<ArrayList<Integer>>();
        A17Result = A17.subsets(nums);
        if (A17Result != null) {
            for (ArrayList<Integer> Temp : A17Result) {
                for (Integer Temp2 : Temp) {
                    System.out.print(Temp2);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}