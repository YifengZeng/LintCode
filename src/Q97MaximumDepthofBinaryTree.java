/**
 * Created by Yifeng Zeng on 1/31/17.
 */
import basicDataStructure.TreeNode;

import java.util.ArrayList;

/*

Maximum Depth of Binary Tree

        Given a binary tree, find its maximum depth.

        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

        Have you met this question in a real interview? Yes
        Example
        Given a binary tree as follow:

            1
           / \
          2   3
         / \
        4   5
        The maximum depth is 3.
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

public class Q97MaximumDepthofBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */

    //recursive
    private int maxDepth;

    public int maxDepth_recursive(TreeNode root) {
        maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        currentDepth(root, 1);
        return maxDepth;
    }

    private void currentDepth(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }

        if (maxDepth < currentDepth) {
            maxDepth = currentDepth;
        }
        currentDepth(root.left, currentDepth + 1);
        currentDepth(root.right, currentDepth + 1);
    }

    //divide & conquer
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Q97MaximumDepthofBinaryTree A97 = new Q97MaximumDepthofBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(A97.maxDepth(root));
        System.out.println(A97.maxDepth_recursive(root));
    }
}
