/**
 * Created by Yifeng Zeng on 2/2/17.
 */
/*

Lowest Common Ancestor

        Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

        The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

        Notice

        Assume two nodes are exist in tree.

        Have you met this question in a real interview? Yes
        Example
        For the following binary tree:

            4
           / \
          3   7
             / \
            5   6
        LCA(3, 5) = 4

        LCA(5, 6) = 7

        LCA(6, 7) = 7
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

public class Q88LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }

    public static void main(String[] args) {
        Q88LowestCommonAncestor A88 = new Q88LowestCommonAncestor();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(A88.lowestCommonAncestor(root, root.left, root.right.left).val); //3, 5 => 4
        System.out.println(A88.lowestCommonAncestor(root, root.right.left, root.right.right).val); //5, 6 => 7
        System.out.println(A88.lowestCommonAncestor(root, root.right.right, root.right).val); //6, 7 => 7
    }
}

