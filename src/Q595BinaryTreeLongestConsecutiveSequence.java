/**
 * Created by Yifeng Zeng on 2/2/17.
 */
/*

Binary Tree Longest Consecutive Sequence

        Given a binary tree, find the length of the longest consecutive sequence path.

        The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

        Have you met this question in a real interview? Yes
        Example
        For example,

        1
         \
          3
         / \
        2   4
             \
              5
        Longest consecutive sequence path is 3-4-5, so return 3.

          2
           \
            3
           /
          2
         /
        1
        Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import basicDataStructure.TreeNode;

public class Q595BinaryTreeLongestConsecutiveSequence {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    private int longestNumber;
    public int longestConsecutive(TreeNode root) {
        longestNumber = 0;
        helper(root);
        return longestNumber;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        int currentLongest = 1;

        if (root.left != null && root.val + 1 == root.left.val) {
            currentLongest = left + 1;
        }
        if (root.right != null && root.val + 1 == root.right.val) {
//            currentLongest = right + 1;
//            currentLongest += right; //can't use this because need to compare with currentLongest from left
            currentLongest = Math.max(currentLongest, right + 1);
        }
        if (longestNumber < currentLongest) {
            longestNumber = currentLongest;
        }
        return currentLongest;
    }

    public static void main(String[] args) {
        Q595BinaryTreeLongestConsecutiveSequence A595 = new Q595BinaryTreeLongestConsecutiveSequence();
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(2);
        root2.right.left.left = new TreeNode(1);
        System.out.println(A595.longestConsecutive(root1));
        System.out.println(A595.longestConsecutive(root2));
        // a case that both leaves might have same value
        //   2
        //  / \
        // 3   3
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(3);
        root3.right.right = new TreeNode(3);
        root3.right.left.right = new TreeNode(4);
        System.out.println(A595.longestConsecutive(root3));

    }
}
