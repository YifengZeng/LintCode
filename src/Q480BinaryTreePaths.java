/**
 * Created by Yifeng Zeng on 1/31/17.
 */

import basicDataStructure.TreeNode;
import java.util.List;
import java.util.ArrayList;
/*

Binary Tree Paths

        Given a binary tree, return all root-to-leaf paths.

        Have you met this question in a real interview? Yes
        Example
        Given the following binary tree:

           1
         /   \
        2     3
         \
          5
        All root-to-leaf paths are:

        [
        "1->2->5",
        "1->3"
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
public class Q480BinaryTreePaths {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */

    //recursive
    public List<String> binaryTreePathsR(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        helper(root, "", paths);
        return paths;
    }
    public void helper(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path += String.valueOf(root.val);
            paths.add(path);
        }

        helper(root.left, path + String.valueOf(root.val) + "->", paths);
        helper(root.right, path + String.valueOf(root.val) + "->", paths);
    }

    //divide & conquer
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        String str = String.valueOf(root.val);
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(str + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(str + "->" + path);
        }

        if (paths.size() == 0) {
            paths.add(str);
        }
        return paths;
    }

    public static void main(String[] args) {
        Q480BinaryTreePaths A480 = new Q480BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<String> result = A480.binaryTreePaths(root);
        for (String i : result) {
            System.out.println(i);
        }
        System.out.println();
        result = A480.binaryTreePathsR(root);
        for (String i : result) {
            System.out.println(i);
        }
    }
}
