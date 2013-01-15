package _path_sum_II;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import _path_sum.Solution.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
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

	private Deque<Integer> stack;
	private ArrayList<ArrayList<Integer>> result;

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		stack = new LinkedList<Integer>();
		result = new ArrayList<ArrayList<Integer>>();

		pathSumHelper(root, sum, 0);
		return result;
	}

	private void pathSumHelper(TreeNode root, int sum, int cum) {
		if (root == null) {
			return;
		}
		int val = root.val;
		cum += val;
		stack.addLast(val);
		if (root.left == null && root.right == null) {
			if (cum == sum) {
				ArrayList<Integer> list = new ArrayList<Integer>(stack);
				result.add(list);
			}
			stack.pollLast();
			return;
		}

		pathSumHelper(root.left, sum, cum);
		pathSumHelper(root.right, sum, cum);
		stack.pollLast();
	}
}
