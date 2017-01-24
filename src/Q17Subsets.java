/**
 * Created by Yifeng Zeng on 1/22/17.
 */
import java.util.ArrayList;

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


        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(123);
        temp.add(456);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(temp);
//        return result;

        if (nums == null) {
            return null;
        }

        return null;

    }


    public static void main(String[] args) {
        Q17Subsets A17 = new Q17Subsets();
        int[] nums = {1,2,3};
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