/**
 * Created by Yifeng Zeng on 1/31/17.
 */

import basicDataStructure.TreeNode;

import java.util.ArrayList;
/*

Minimum Subtree

        Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

        Notice

        LintCode will print the subtree which root is your return node.
        It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.

        Have you met this question in a real interview? Yes
        Example
        Given a binary tree:

             1
           /   \
         -5     2
         / \   /  \
        0   2 -4  -5
        return the node 1.
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

public class Q596MinimumSubtree {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    //traversal + divide & conquer
    private TreeNode subtree = null;
    private Integer subtreeSum;
    public TreeNode findSubtreeR(TreeNode root) {
        subtreeSum = Integer.MAX_VALUE;
        findSubtreeHelperR(root);
        return subtree;
    }
    private Integer findSubtreeHelperR(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Integer sum = root.val + findSubtreeHelperR(root.left) + findSubtreeHelperR(root.right);
        if (subtreeSum > sum) {
            subtreeSum = sum;
            subtree = root;
        }
        return sum;
    }

    //divide & conquer only, with custom return struct
    class returnType {
        public TreeNode subtree;
        public int currentSum;
        public int minSum;
        public returnType(TreeNode subtree, int currentSum, int minSum) {
            this.subtree = subtree;
            this.currentSum = currentSum;
            this.minSum = minSum;
        }
    }
    private returnType findSubtreeHelper(TreeNode root) {
        returnType result = new returnType(root, 0, Integer.MAX_VALUE);
        if (root == null) {
            return result;
        }

        returnType leftSubtree = findSubtreeHelper(root.left);
        returnType rightSubtree = findSubtreeHelper(root.right);
        result.currentSum = leftSubtree.currentSum + rightSubtree.currentSum + root.val;
        if (leftSubtree.minSum < rightSubtree.minSum) {
            if (result.currentSum > leftSubtree.minSum) {
                result.subtree = leftSubtree.subtree;
                result.minSum = leftSubtree.minSum;
            } else if (result.currentSum > rightSubtree.minSum){
                result.subtree = rightSubtree.subtree;
                result.minSum = rightSubtree.minSum;
            } else {
                result.subtree = root;
                result.minSum = result.currentSum;
            }
        } else {
            if (result.currentSum > rightSubtree.minSum) {
                result.subtree = rightSubtree.subtree;
                result.minSum = rightSubtree.minSum;
            } else if (result.currentSum > leftSubtree.minSum){
                result.subtree = leftSubtree.subtree;
                result.minSum = leftSubtree.minSum;
            } else {
                result.subtree = root;
                result.minSum = result.currentSum;
            }
        }
        return result;
    }
    public TreeNode findSubtree(TreeNode root) {
        /*if (root == null) {
            return null;
        }*/
        return findSubtreeHelper(root).subtree;
    }

    public static void main(String[] args) {
        Q596MinimumSubtree A596 = new Q596MinimumSubtree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(-4);
        root.right.right = new TreeNode(-5);
        System.out.print("root:\t");
        TreeNode.preoderTraversal(root);
        TreeNode result = A596.findSubtreeR(root);
        System.out.print("R:\t\t");
        TreeNode.preoderTraversal(result);
        result = A596.findSubtree(root);
        System.out.print("D&C:\t");
        TreeNode.preoderTraversal(result);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);
        root2.left.left.left = new TreeNode(8);
        System.out.print("root:\t");
        TreeNode.preoderTraversal(root2);
        result = A596.findSubtree(root2);
        System.out.print("D&C:\t");
        TreeNode.preoderTraversal(result);
    }
}
