package _symmetric_tree;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_iterative {
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
		Deque<TreeNode> left = new LinkedList<TreeNode>();
		Deque<TreeNode> right = new LinkedList<TreeNode>();
		left.addLast(root.left);
		right.addLast(root.right);
		while (left.size() != 0) {
			TreeNode l = left.pollLast();
			TreeNode r = right.pollLast();
			if (l.val != r.val) {
				return false;
			}
			if (!isEqual(l.left, r.right) || !isEqual(l.right, r.left)) {
				return false;
			}
			if (l.left != null) {
				left.addLast(l.left);
			}
			if (l.right != null) {
				left.addLast(l.right);
			}
			if (r.right != null) {
				right.addLast(r.right);
			}
			if (r.left != null) {
				right.addLast(r.left);
			}
		}
		return true;
	}

	private boolean isEqual(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		}
		if (l == null || r == null) {
			return false;
		}
		if (l.val == r.val) {
			return true;
		}
		return false;
	}
}
