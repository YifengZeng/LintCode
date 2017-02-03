package basicDataStructure;

import java.util.ArrayList;
import java.util.Stack;
/**
 * Created by Yifeng Zeng on 1/31/17.
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    //non-recursive pre-order traversal
    public static void preoderTraversal(TreeNode root) {
        ArrayList<Integer> preoder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }

        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            preoder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        for (Integer i : preoder) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}

