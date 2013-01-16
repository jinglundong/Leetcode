package _unique_binary_search_tree_II;

import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that
 * store values 1...n.
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<TreeNode>> allUnique = new ArrayList<ArrayList<TreeNode>>();
        init(allUnique);
        // creating a tree with size i from i-1
        for (int i = 2; i <= n; i++) {
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            // The size of left subtree could be 0 through i-1
            for (int j = 0; j < i; j++) {
                for (TreeNode left : allUnique.get(j)) {
                    // the size of right subtree is i-j-1
                    for (TreeNode right : allUnique.get(i - j - 1)) {
                        // clone a new tree
                        TreeNode l = clone(left, 0);
                        TreeNode m = new TreeNode(j + 1);
                        TreeNode r = clone(right, j + 1);
                        m.left = l;
                        m.right = r;
                        list.add(m);
                    }
                }
            }
            allUnique.add(list);
        }
        return allUnique.get(n);
    }

    // increment is used to deal with right subtree
    private TreeNode clone(TreeNode root, int increment) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val + increment);
        newRoot.left = clone(root.left, increment);
        newRoot.right = clone(root.right, increment);
        return newRoot;
    }

    private void init(ArrayList<ArrayList<TreeNode>> allUnique) {
        // for zero node
        ArrayList<TreeNode> list0 = new ArrayList<TreeNode>();
        list0.add(null);
        allUnique.add(list0);

        // for one node
        TreeNode tmp1 = new TreeNode(1);
        ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
        list1.add(tmp1);
        allUnique.add(list1);
    }
}