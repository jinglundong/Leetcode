package _unique_paths;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	private int[][] ways;

	public int uniquePaths(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		this.ways = new int[m][n];

		for (int i = 0; i < m; i++) {
			ways[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			ways[0][j] = 1;
		}
		return uniquePathsHelper(m - 1, n - 1);
	}

	public int uniquePathsHelper(int m, int n) {
		if (m < 0 || n < 0) {
			return 0;
		}
		if (ways[m][n] == 0) {
			ways[m][n] = uniquePathsHelper(m - 1, n)
					+ uniquePathsHelper(m, n - 1);
		}
		return ways[m][n];
	}
}