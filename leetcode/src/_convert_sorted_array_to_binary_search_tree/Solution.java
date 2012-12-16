package _convert_sorted_array_to_binary_search_tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * @author Jinglun
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

	private int[] num;

	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		this.num = num;
		if (num == null || num.length == 0) {
			return null;
		}
		return subTree(0, num.length - 1);
	}

	private TreeNode subTree(int left, int right) {
		// contains only one node
		if (left == right) {
			return new TreeNode(num[left]);
		}
		if (left > right) {
			return null;
		}
		TreeNode root = new TreeNode(num[left + (right - left) / 2]);
		root.left = subTree(left, left + (right - left) / 2 - 1);
		root.right = subTree(left + (right - left) / 2 + 1, right);
		return root;
	}
}
