package _balance_binary_tree_AVL;

public class Solution {
	  //Definition for binary tree
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null){
            return true;
        }
        if (depthCheck(root) == Integer.MIN_VALUE){
            return false;
        }
        else{
            return true;
        }
    }
    
    public int depthCheck(TreeNode root){
        if (root == null){
            return -1;
        }
        int left = depthCheck(root.left);
        int right = depthCheck(root.right);
        if (left == Integer.MIN_VALUE || right == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if (Math.abs(left - right) <=1){
            return Math.max(left, right) +1;
        }
        else{
            return Integer.MIN_VALUE;
        }
    }
}