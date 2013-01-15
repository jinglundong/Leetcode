package _binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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

	private ArrayList<ArrayList<Integer>> result;

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		this.result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}

		// base case
		ArrayList<TreeNode> first = new ArrayList<TreeNode>();
		first.add(root);
		ArrayList<Integer> firstInt = new ArrayList<Integer>();
		firstInt.add(root.val);
		result.add(firstInt);

		zigzagHelper(first, false);
		return result;
	}

	public void zigzagHelper(ArrayList<TreeNode> list, boolean fromLeft) {
		if (list.size() == 0) {
			return;
		}
		ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int size = list.size();

		// an ugly main loop...
		for (int i = size - 1; i >= 0; i--) {
			TreeNode l = list.get(i).left;
			TreeNode r = list.get(i).right;
			if (fromLeft) {
				if (l != null) {
					result.add(l.val);
					nextLevel.add(l);
				}
				if (r != null) {
					result.add(r.val);
					nextLevel.add(r);
				}
				continue;
			}
			// from right
			if (r != null) {
				result.add(r.val);
				nextLevel.add(r);
			}
			if (l != null) {
				result.add(l.val);
				nextLevel.add(l);
			}
		}

		if (result.size() != 0) {
			this.result.add(result);
		}
		// recursion
		zigzagHelper(nextLevel, !fromLeft);
	}
}