/**
 * Created by Yifeng Zeng on 2/3/17.
 */
/*

Binary Tree Path Sum

        Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

        A valid path is from root node to any of the leaf nodes.

        Have you met this question in a real interview? Yes
        Example
        Given a binary tree, and target = 5:

            1
           / \
          2   4
         / \
        2   3
        return

        [
        [1, 2, 2],
        [1, 4]
        ]
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
import basicDataStructure.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Q376BinaryTreePathSum {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        //get the sum of root-current node, and if it is target, save path into result
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        int sum = root.val;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(target, sum, root, path, result);
        return result;
    }

    private void helper(int target,
                   int sum,
                   TreeNode root,
                   ArrayList<Integer> path,
                   List<List<Integer>> result) {
        //leaf
        if (root.left == null && root.right == null) {
            if (target == sum) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            helper(target, sum + root.left.val, root.left, path, result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            helper(target, sum + root.right.val, root.right, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        Q376BinaryTreePathSum a376 = new Q376BinaryTreePathSum();
        List<List<Integer>> result = new ArrayList<>();
        result = a376.binaryTreePathSum(root, 5);
        for (List<Integer> i : result) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
