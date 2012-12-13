package _binary_tree_level_order_traversal;

import java.util.ArrayList;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7 return
 * its level order traversal as: [ [3], [9,20], [15,7] ]
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> prev = new ArrayList<TreeNode>();
        prev.add(root);
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        while (!prev.isEmpty()) {
            result.add(new ArrayList<Integer>());
            cur.clear();
            for (TreeNode it : prev) {
                result.get(result.size() - 1).add(it.val);
                if (it.left != null) {
                    cur.add(it.left);
                }
                if (it.right != null) {
                    cur.add(it.right);
                }
            }
            prev = new ArrayList<TreeNode>(cur);
        }
        return result;
    }
}
