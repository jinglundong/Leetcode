package _unique_paths_II;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	private int[][] obstacle;
	private int[][] ways;

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		this.obstacle = obstacleGrid;
		this.ways = new int[m][n];
		init();
		return uniquePathsWithObstacles(m - 1, n - 1);
	}

	private int uniquePathsWithObstacles(int m, int n) {
		if (m < 0 || n < 0) {
			return 0;
		}
		if (m == 0 || n == 0) {
			return ways[m][n];
		}
		if (obstacle[m][n] == 1) {
			return 0;
		}
		if (ways[m][n] == 0) {
			ways[m][n] = uniquePathsWithObstacles(m - 1, n)
					+ uniquePathsWithObstacles(m, n - 1);
		}
		return ways[m][n];
	}

	private void init() {
		for (int i = 0; i < ways.length; i++) {
			if (obstacle[i][0] == 1) {
				break;
			}
			ways[i][0] = 1;
		}
		for (int j = 0; j < ways[0].length; j++) {
			if (obstacle[0][j] == 1) {
				break;
			}
			ways[0][j] = 1;
		}
	}
}
