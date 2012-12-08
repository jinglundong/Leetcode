package _search_a_2d_matrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [[1, 3, 5, 7], 
 *  [10, 11, 16, 20], 
 *  [23, 30, 34, 50] ] 
 * Given target = 3, return
 * true.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int row = 0;
		int col = cols - 1;
		return subSearch(matrix, target, 0, cols - 1);
	}

	private boolean subSearch(int[][] matrix, int target, int row, int col) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (matrix[row][col] == target) {
			return true;
		}
		if (row == rows - 1 && col == 0) { // reach left bottom corner, no match
			return false;
		}
		if (col == 0) { // on the left boundary
			if (target < matrix[row][col]) {
				return false;
			} else {
				return subSearch(matrix, target, row + 1, col); // row+1
																// wouldn't out
																// of boundary
			}
		}
		if (row == rows - 1) { // on the bottom boundary
			if (target > matrix[row][col]) {
				return false;
			} else {
				return subSearch(matrix, target, row, col - 1);
			}
		}
		// left and down candidates are both valid
		if (target > matrix[row][col]) {
			return subSearch(matrix, target, row + 1, col);
		} else {
			return subSearch(matrix, target, row, col - 1);
		}
	}
}
