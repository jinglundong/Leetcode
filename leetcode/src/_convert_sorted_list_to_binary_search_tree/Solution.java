package _convert_sorted_list_to_binary_search_tree;

import java.util.ArrayList;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> array = new ArrayList<Integer>();
		while (head != null) {
			array.add(head.val);
			head = head.next;
		}
		return subTree(array, 0, array.size() - 1);
	}

	private TreeNode subTree(ArrayList<Integer> array, int left, int right) {
		if (left == right) {
			return new TreeNode(array.get(left));
		}
		if (left > right) {
			return null;
		}
		TreeNode root = new TreeNode(array.get(left + (right - left) / 2));
		root.left = subTree(array, left, left + (right - left) / 2 - 1);
		root.right = subTree(array, left + (right - left) / 2 + 1, right);
		return root;
	}
}
