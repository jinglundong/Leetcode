package _min_depth_of_binary_tree;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.Set;
 import java.util.HashSet;
 
public class Solution {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 1;
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        Set<TreeNode> cur = new HashSet<TreeNode>();
        Set<TreeNode> next = new HashSet<TreeNode>();
        cur.add(root);
        while(true){
            for (TreeNode it: cur){
                if (it.left == null && it.right == null){
                    return result;
                }
                else{
                    if (it.left != null){
                        next.add(it.left);
                    }
                    if (it.right != null){
                        next.add(it.right);
                    }
                }                
            }
            result++;
            cur.clear();
            cur.addAll(next);
            next.clear();
        }
    }    
}