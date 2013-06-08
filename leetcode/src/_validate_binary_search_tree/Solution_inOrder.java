package _validate_binary_search_tree;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution_inOrder {
    Integer prev;
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return true;
        }
        prev = Integer.MIN_VALUE;
        return inOrder(root);
    }
    
    private boolean inOrder(TreeNode root){
        if (root == null){
            return true;
        }
        if (!inOrder(root.left)){
            return false;
        }
        if (root.val <= prev){
            return false;
        }
        prev = root.val;
        return inOrder(root.right);
    }
}