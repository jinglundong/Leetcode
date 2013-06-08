package _validate_binary_search_tree;

/**
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 */
public class Solution {
    static class MinMax {
        public int minValue;
        public int maxValue;

        public MinMax(int min, int max) {
            minValue = min;
            maxValue = max;
        }

        public MinMax() {
        }
    }

    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        }
        isValid = true;
        isValidBSTHelper(root);
        return isValid;
    }

    private MinMax isValidBSTHelper(TreeNode root) {
        if (!isValid) {
            return new Solution.MinMax();
        }
        if (root == null) {
            return new Solution.MinMax(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        MinMax left = isValidBSTHelper(root.left);
        MinMax right = isValidBSTHelper(root.right);
        if (!isValid) {
            return new Solution.MinMax();
        }
        if (left.maxValue >= root.val || right.minValue <= root.val) {
            isValid = false;
            return new Solution.MinMax();
        }
        int tmpMin = left.minValue == Integer.MAX_VALUE ? root.val
                : left.minValue;
        int tmpMax = right.maxValue == Integer.MIN_VALUE ? root.val
                : right.maxValue;
        return new Solution.MinMax(tmpMin, tmpMax);
    }
}