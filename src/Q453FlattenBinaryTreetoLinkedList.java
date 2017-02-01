/**
 * Created by Yifeng Zeng on 1/31/17.
 */
/*

Flatten Binary Tree to Linked List

        Flatten a binary tree to a fake "linked list" in pre-order traversal.

        Here we use the right pointer in TreeNode as the next pointer in ListNode.

        Notice

        Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

        Have you met this question in a real interview? Yes
        Example
                        1
                         \
               1          2
              / \          \
             2   5    =>    3
            / \   \          \
           3   4   6          4
                               \
                                5
                                 \
                                  6
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

public class Q453FlattenBinaryTreetoLinkedList {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode lastLeftNode = helper(root.left);
        TreeNode lastRightNode = helper(root.right);

        if (lastLeftNode != null) {
            lastLeftNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (lastRightNode != null) {
            return lastRightNode;
        }
        if (lastLeftNode != null) {
            return lastLeftNode;
        }
        return root;
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    public static void main(String[] args) {
        Q453FlattenBinaryTreetoLinkedList A453 =  new Q453FlattenBinaryTreetoLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        TreeNode.preoderTraversal(root);
        A453.flatten(root);
        TreeNode.preoderTraversal(root);
    }
}
