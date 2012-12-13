package _binary_tree_level_order_traversalII;

import java.util.ArrayList;

import _binary_tree_level_order_traversal.Solution.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7]
      [9,20],
      [3],
    ]
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

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(0, new ArrayList<Integer>());
            cur.clear();
            for (TreeNode it : prev) {
                result.get(0).add(it.val);
                if (it.left != null) {
                    cur.add(it.left);
                }
                if (it.right != null) {
                    cur.add(it.right);
                }
            }
            ArrayList<TreeNode> tmp = prev;
            prev = cur;
            cur = tmp;
        }
        return result;
    }
}