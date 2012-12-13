package _binary_tree_inorder_traversal;

import java.util.ArrayList;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 
 * 1 
 *  \ 
 *   2 
 *  / 
 * 3 
 * return [1,3,2].
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

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        subInorder(root, result);
        return result;

    }

    private void subInorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        } else {
            subInorder(root.left, result);
            result.add(root.val);
            subInorder(root.right, result);
        }
    }
}
