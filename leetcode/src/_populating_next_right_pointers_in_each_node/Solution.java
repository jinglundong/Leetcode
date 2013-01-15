package _populating_next_right_pointers_in_each_node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a binary tree
 * 
 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right; TreeLinkNode
 * *next; } Populate each next pointer to point to its next right node. If there
 * is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (ie, all leaves are at the same level, and every parent has two
 * children).
 * 
 * This solution use o(k) extra space, where k is the maximum nodes in all levels
 * Provide a solution using constant extra space in follow up question.
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
		if (root == null || root.left == null) {
			return;
		}
		int pos = 0; // the position of current node in current level
		int nodes = 1; // number of nodes in current level
		Deque<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.addFirst(root);
		while (!queue.isEmpty()) {
			TreeLinkNode node = queue.pollFirst();
			if (pos == nodes - 1) { // the right most node in each level
				pos = 0;
				nodes = nodes << 1;
			} else {
				node.next = queue.peekFirst();
				pos++;
			}
			if (node.left != null) { // since it is complete, no need to check
										// right child
				queue.addLast(node.left);
				queue.addLast(node.right);
			}
		}
	}
}
