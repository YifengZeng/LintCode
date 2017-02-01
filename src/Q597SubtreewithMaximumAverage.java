/**
 * Created by Yifeng Zeng on 1/31/17.
 */
/*

Subtree with Maximum Average

        Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

        Notice

        LintCode will print the subtree which root is your return node.
        It's guaranteed that there is only one subtree with maximum average.

        Have you met this question in a real interview? Yes
        Example
        Given a binary tree:

             1
           /   \
         -5     11
         / \   /  \
        1   2 4    -2
        return the node 11.
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

public class Q597SubtreewithMaximumAverage {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    class returnType {
        int sum;
        int size;
        returnType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }

    returnType result = null;
    TreeNode resultNode = null;
    //for the root given, get the max sum/size
    private returnType helper(TreeNode root) {
        if (root == null) {
            return new returnType(0,0);
        }

        returnType left = helper(root.left);
        returnType right = helper(root.right);
        int currentSize = left.size + right.size + 1;
        int currentSum = left.sum + right.sum + root.val;
        returnType currentResult = new returnType(currentSum, currentSize);
        if (resultNode == null || result.sum * currentSize < currentSum * result.size) {
            result = currentResult;
            resultNode = root;
        }
        return currentResult;
    }
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return resultNode;
    }


    public static void main(String[] args) {
        Q597SubtreewithMaximumAverage A597 = new Q597SubtreewithMaximumAverage();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(-2);
        System.out.print("root:\t");
        TreeNode.preoderTraversal(root);
        TreeNode result = A597.findSubtree2(root);
        System.out.print("result:\t");
        TreeNode.preoderTraversal(result);
    }
}
