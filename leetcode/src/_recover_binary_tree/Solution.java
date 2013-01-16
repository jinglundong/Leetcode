package _recover_binary_tree;

import java.util.LinkedList;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * 
 * Despite of the space of stack(activation records), this implementation uses O(1) space.
 * In-order traverse of tree, there is a misplace if prev.val > curr.val. 
 * If two places are found, swap them. If only one place found, swap the two involved nodes. 
 */
public class Solution {
    LinkedList<TreeNode> candidates;
    int misplaceFound;
    TreeNode prev;
    TreeNode curr;

    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        candidates = new LinkedList<TreeNode>();
        misplaceFound = 0;
        prev = new TreeNode(Integer.MIN_VALUE);
        curr = root;
        inorder(root);
        if (misplaceFound == 1) {
            swap(candidates.get(0), candidates.get(1));
        }
    }

    private void inorder(TreeNode root) {
        if (misplaceFound == 2) {
            return;
        }
        if (root == null) {
            return;
        }
        inorder(root.left);
        curr = root;
        if (prev.val > curr.val) {
            if (misplaceFound == 0) {
                candidates.add(prev);
                candidates.add(curr);
            } else { // misplaceFound == 1
                swap(candidates.get(0), curr);
            }
            misplaceFound++;
        }
        prev = curr;
        inorder(root.right);
    }

    private void swap(TreeNode t1, TreeNode t2) {
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }
}
