package _maximal_rectangle;

import java.util.Arrays;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int result = 0;
		int[][] colCount = new int[matrix.length][matrix[0].length];

		initMatrix(colCount, matrix);

		// main loop
		for (int i = 0; i < matrix.length; i++) {
			result = Math.max(result, rowMax(matrix, colCount, i, 0));
		}
		return result;
	}

	private void initMatrix(int[][] colCount, char[][] matrix) {
		// fill matrix colCount with 0
		final int matrixWidth = matrix[0].length;
		final int matrixHeight = matrix.length;

		int rows = 0;

		for (int i = 0; i < matrixHeight; i++) {
			Arrays.fill(colCount[i], 0);
		}
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (matrix[i][j] == '0') {
					continue;
				}
				// matrix[row][j] == '1', count how many adjacent '1's in
				// current column
				if (i == 0 || colCount[i - 1][j] == 0) { // calculate rows by
															// linear counting
					rows = 1;
					int tmpRow = i;
					// scan vertically
					while (++tmpRow < matrixHeight) {
						if (matrix[tmpRow][j] == '1') {
							rows++;
							continue;
						}
						break;
					}
				} else { // calculate rows from above rows
							// i != 0 && colCount[i-1][j] != 0
					rows = colCount[i - 1][j] - 1;
				}
				colCount[i][j] = rows;
			}
		}
	}

	private int rowMax(char[][] matrix, int[][] colCount, int i, int j) {
		final int matrixWidth = matrix[0].length;
		final int matrixHeight = matrix.length;

		int result = 0;

		if (j >= matrixWidth) {
			return 0;
		}

		// recursion goes here.
		result = Math.max(result, rowMax(matrix, colCount, i, j + 1));

		if (matrix[i][j] == '1') {
			int rows = Integer.MAX_VALUE;
			int cols = 0;
			while (j < matrixWidth && colCount[i][j] != 0) {
				rows = Math.min(rows, colCount[i][j]);
				cols++;
				result = Math.max(result, rows * cols);
				j++;
			}
		}

		return result;
	}

}