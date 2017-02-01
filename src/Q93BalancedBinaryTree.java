/**
 * Created by Yifeng Zeng on 1/31/17.
 */
/*

Balanced Binary Tree

        Given a binary tree, determine if it is height-balanced.

        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

        Have you met this question in a real interview? Yes
        Example
        Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

        A)  3            B)    3
           / \                  \
          9  20                 20
            /  \                / \
           15   7              15  7
        The binary tree A is a height-balanced binary tree, but B is not.
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

public class Q93BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    class returnType {
        public boolean isBalanced;
        public int maxDepth;
        returnType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }
    private returnType helper(TreeNode root) {
        if (root == null) {
            return new returnType(true, 0);
        }

        returnType left = helper(root.left);
        returnType right = helper(root.right);
        //if left or right is not balanced, then root is not balanced
        if (!left.isBalanced || !right.isBalanced) {
            return new returnType(false, -1);
        }
        //if depth_diff > 1, then root is not balanced
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new returnType(false, -1);
        }
        //root is balanced
        return new returnType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    public static void main(String[] args) {
        Q93BalancedBinaryTree A93 = new Q93BalancedBinaryTree();
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left = new TreeNode(7);
        System.out.println(A93.isBalanced(root));
        root.left = new TreeNode(9);
        System.out.println(A93.isBalanced(root));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        System.out.println(A93.isBalanced(root2));

    }
}
