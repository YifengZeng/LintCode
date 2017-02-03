/**
 * Created by Yifeng Zeng on 2/2/17.
 */
/*

Lowest Common Ancestor II

        Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

        The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

        The node has an extra attribute parent which point to the father of itself. The root's parent is null.

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
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */

import java.util.ArrayList;

public class Q474LowestCommonAncestorII {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {

        ParentTreeNode lca = root;
        ArrayList<ParentTreeNode> pathA = getNode2RootPath(A);
        ArrayList<ParentTreeNode> pathB = getNode2RootPath(B);

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                return lca;
            }
            lca = pathA.get(indexA);
            indexA--;
            indexB--;
        }

        return lca;
    }

    private ArrayList<ParentTreeNode> getNode2RootPath(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<>();

        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }

    private static class ParentTreeNode {
        public int val;
        public ParentTreeNode parent, left, right;
        public ParentTreeNode(int val) {
            this.val = val;
            this.left = this.right = this.parent = null;
        }
    }

    public static void main(String[] args) {
        Q474LowestCommonAncestorII A474 = new Q474LowestCommonAncestorII();
        ParentTreeNode root = new ParentTreeNode(1);
        ParentTreeNode result = A474.lowestCommonAncestorII(root, root, root);
        System.out.println(result.val);
    }

}



