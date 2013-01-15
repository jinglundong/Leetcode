package _path_sum;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
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

	public boolean hasPathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return false;
		}
		int val = root.val;
		if (root.left == null && root.right == null) {
			if (val == sum) {
				return true;
			}
			return false;
		}
		return hasPathSum(root.left, sum - val)
				|| hasPathSum(root.right, sum - val);
	}
}
