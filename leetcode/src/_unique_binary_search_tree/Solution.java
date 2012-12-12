package _unique_binary_search_tree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 * 
 * For example, Given n = 3, there are a total of 5 unique BST's.
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] unique = new int[n + 1];
        // base case
        unique[0] = 1;
        unique[1] = 1;
        unique[2] = 2;
        // sum the number of unique BST of each number being the root
        for (int i = 3; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += unique[j - 1] * unique[i - j];
            }
            unique[i] = sum;
        }
        return unique[n];
    }
}
