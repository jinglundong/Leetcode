package _construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.Map;
import java.util.HashMap;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
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

	private int[] preorder;
	private int[] inorder;
	private Map<Integer, Integer> preIndex;
	private Map<Integer, Integer> inIndex;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// Map from node value to its array index
		this.preorder = preorder;
		this.inorder = inorder;
		this.preIndex = new HashMap<Integer, Integer>();
		this.inIndex = new HashMap<Integer, Integer>();
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		for (int i = 0; i < preorder.length; i++) {
			preIndex.put(preorder[i], i);
			inIndex.put(inorder[i], i);
		}
		return buildSubTree(0, preorder.length - 1, 0, preorder.length - 1);

	}

	private TreeNode buildSubTree(int preLeft, int preRight, int inLeft,
			int inRight) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		if (preRight == preLeft) {
			return new TreeNode(preorder[preLeft]);
		}
		if (preRight < preLeft) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preLeft]);
		int rootIndex = inIndex.get(preorder[preLeft]);
		int leftSubtreeSize = rootIndex - inLeft;
		int rightSubtreeSize = inRight - rootIndex;
		root.left = buildSubTree(preLeft + 1, preLeft + leftSubtreeSize,
				inLeft, rootIndex - 1);
		root.right = buildSubTree(preRight - rightSubtreeSize + 1, preRight,
				rootIndex + 1, inRight);
		return root;
	}
}
