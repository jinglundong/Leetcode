package _flatten_binary_tree_to_linked_list;

import java.util.ArrayList;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * @author jinglun
 * 
 */
public class Solution {
    ArrayList<TreeNode> list;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }
        list = new ArrayList<TreeNode>();
        preOrderDFS(root);
        relink();
    }

    private void preOrderDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrderDFS(root.left);
        preOrderDFS(root.right);
    }

    private void relink() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).left = null;

            if (i == list.size() - 1) {
                list.get(i).right = null;
            } else {
                list.get(i).right = list.get(i + 1);
            }
        }
    }
}