package _binary_tree_maximum_path_sum;

/**
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * @author jinglun
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

    private int result;

    public Solution() {
        super();
        this.result = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = Integer.MIN_VALUE;
        subMax(root);
        return result;
    }

    private int subMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            result = Math.max(result, root.val); // update result, if root.val
                                                 // is greater
            return root.val;
        }
        // one of root's child is null
        if (root.left == null || root.right == null) {
            int other;
            if (root.left == null) {
                other = subMax(root.right);
            } else {
                other = subMax(root.left);
            }
            int tmpMax = Math.max(root.val, root.val + other);
            result = Math.max(result, tmpMax);
            return tmpMax;
        }
        // both left and right child are not null
        int left = subMax(root.left);
        int right = subMax(root.right);
        int withoutRoot = Math.max(left, right);
        int withRoot = Math.max(withoutRoot + root.val, root.val);
        int leftRootRight = Math.max(withRoot, left + root.val + right);
        result = Math.max(result, leftRootRight);
        return withRoot;
    }
}