import basicDataStructure.TreeNode;

/**
 * Created by Yifeng Zeng on 2/2/17.
 */
/*

Lowest Common Ancestor III

        Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
        The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
        Return null if LCA does not exist.

        Notice

        node A or node B may not exist in tree.

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
public class Q578LowestCommonAncestorIII {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    class returnType {
        public boolean foundA;
        public boolean foundB;
        public TreeNode lca;
        returnType(boolean foundA, boolean foundB, TreeNode lca) {
            this.foundA = foundA;
            this.foundB = foundB;
            this.lca = lca;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {

        returnType lca = lowestCommonAncestor3helper(root, A, B);
        if (lca.foundA && lca.foundB) {
            return lca.lca;
        }
        return null;

    }
    public returnType lowestCommonAncestor3helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new returnType(false, false, null);
        }
//        if (root == A) {
//            return new returnType(true, false, A);
//        }
//        if (root == B) {
//            return new returnType(false, true, B);
//        }

        returnType left = lowestCommonAncestor3helper(root.left, A, B);
        returnType right = lowestCommonAncestor3helper(root.right, A, B);

        boolean foundA = left.foundA || right.foundA || root == A;
        boolean foundB = left.foundB || right.foundB || root == B;

        if (root == A || root == B) {
            return new returnType(foundA, foundB, root);
        }
        if (left.lca != null && right.lca != null) {
            return new returnType(foundA, foundB, root);
        }
        if (left.lca != null) {
            return new returnType(foundA, foundB, left.lca);
        }
        if (right.lca != null) {
            return new returnType(foundA, foundB, right.lca);
        }
        return new returnType(foundA, foundB, null);
    }


    public static void main(String[] args) {
        Q578LowestCommonAncestorIII A88 = new Q578LowestCommonAncestorIII();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeNode B = new TreeNode(8);
        System.out.println(A88.lowestCommonAncestor3(root, root.left, root.right.left).val); //3, 5 => 4
        System.out.println(A88.lowestCommonAncestor3(root, root.right.left, root.right.right).val); //5, 6 => 7
        System.out.println(A88.lowestCommonAncestor3(root, root.right.right, root.right).val); //6, 7 => 7
        TreeNode result = A88.lowestCommonAncestor3(root, root.right.right, B);
        if (result == null) {
            System.out.println("null"); //6, 8 => null
        }
    }
}
