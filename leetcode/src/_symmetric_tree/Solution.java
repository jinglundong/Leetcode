package _symmetric_tree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * @author Jinglun
 * 
 * Recursive approach, using 5 mins. Bug free!
 */
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (root.left == null || root.right == null) {
			return false;
		}
		return isSymmetricHelper(root.left, root.right);
	}

	private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		boolean outter = isSymmetricHelper(left.left, right.right);
		boolean inner = isSymmetricHelper(left.right, right.left);
		if (outter && inner) {
			return true;
		}
		return false;
	}
}