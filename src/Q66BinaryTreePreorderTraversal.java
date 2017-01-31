/**
 * Created by Yifeng Zeng on 1/31/17.
 */

import basicDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/*

Binary Tree Preorder Traversal

        Given a binary tree, return the preorder traversal of its nodes' values.

        Have you met this question in a real interview? Yes
        Example
        Given:

           1
          / \
         2   3
        / \
        4   5
        return [1,2,4,5,3].
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

public class Q66BinaryTreePreorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */

    //non-recursive
    public ArrayList<Integer> preorderTraversal_nonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> preorder = new ArrayList<>();

        if (root == null) {
            return preorder;
        }

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return preorder;
    }

    //recursive
    public ArrayList<Integer> preorderTraversal_recursive(TreeNode root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        traverse(root, preorder);
        return preorder;
    }
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    //divide & conquer
    public ArrayList<Integer> preorderTraversal_divideNconquer(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        //devide
        ArrayList<Integer> left = preorderTraversal_divideNconquer(root.left);
        ArrayList<Integer> right = preorderTraversal_divideNconquer(root.right);

        //conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }


    public static void main(String[] args) {
        Q66BinaryTreePreorderTraversal A66 = new Q66BinaryTreePreorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> arr = A66.preorderTraversal_nonRecursive(root);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        arr = A66.preorderTraversal_recursive(root);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        arr = A66.preorderTraversal_divideNconquer(root);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
