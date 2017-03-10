/**
 * Created by Yifeng Zeng on 2/7/17.
 */
/*

Validate Binary Search Tree

        Given a binary tree, determine if it is a valid binary search tree (BST).

        Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.
        A single node tree is a BST
        Have you met this question in a real interview? Yes
        Example
        An example:

            2
           / \
          1   4
             / \
            3   5
        The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

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

public class Q95ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        return helper(root);

    }

//    class returnType {
//        boolean
//    }
    //pass in the sub-root, and return if it BST
    private boolean helper(TreeNode root) {
        boolean left = false;
        boolean right = false;
        if (root.left == null) {
            left = true;
        }
        if (root.right == null) {
            right = true;
        }
        if (root.left != null && root.left.val < root.val) {
            left = helper(root.left);
        }
        if (root.right != null && root.right.val > root.val) {
            right = helper(root.right);
        }
        if (left && right) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Q95ValidateBinarySearchTree a95 = new Q95ValidateBinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        System.out.println(a95.isValidBST(root));
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        System.out.println(a95.isValidBST(root));
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(20);
        System.out.println(a95.isValidBST(root2));
    }
}
