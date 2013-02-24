package _sum_root_to_leaf_numbers;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sumNumbersHelper(root, 0);
    }
    
    private int sumNumbersHelper(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        sum = sum * 10 + root.val;
        //base case
        if(root.left == null && root.right == null){
            return sum;
        }
        //recursion
        return sumNumbersHelper(root.left, sum) + 
            sumNumbersHelper(root.right, sum);
    }
}
