package _populating_next_right_pointers_in_each_node_II;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space. For example, Given the following
 * binary tree,
 */
public class Solution {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeLinkNode head = root;
		TreeLinkNode childHead = null;

		// base and coner cases
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		if (root.left != null) {
			childHead = root.left;
			if (root.right != null) {
				root.left.next = root.right;
			}
		} else {
			childHead = root.right;
		}

		// main loop
		while (childHead != null) {
			root = childHead;
			childHead = null;
			TreeLinkNode prev = null;
			while (root != null) {
				// has two children
				if (root.left != null && root.right != null) {
					if (prev != null) {
						prev.next = root.left;
					}
					root.left.next = root.right;
					prev = root.right;
					if (childHead == null) {
						childHead = root.left;
					}
					root = root.next;
					continue;
				}
				if (root.left != null) {
					if (childHead == null) {
						childHead = root.left;
					}
					if (prev != null) {
						prev.next = root.left;
					}
					prev = root.left;
					root = root.next;
					continue;
				}
				if (root.right != null) {
					if (childHead == null) {
						childHead = root.right;
					}
					if (prev != null) {
						prev.next = root.right;
					}
					prev = root.right;
					root = root.next;
					continue;
				}
				// both are null;
				root = root.next;
			}
		}
	}
}