package _spiral_matrix_II;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5
 * ] ]
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	enum Side {
		UP, RIGHT, BOTTOM, LEFT
	};

	private Side side;

	class Boundray {
		int up;
		int right;
		int bottom;
		int left;

		Boundray(int up, int right, int bottom, int left) {
			super();
			this.up = up;
			this.right = right;
			this.bottom = bottom;
			this.left = left;
		}
	}

	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		this.side = Side.UP;
		Boundray boundray = new Boundray(0, n - 1, n - 1, 0);
		int[][] result = new int[n][n];
		int num = 1;
		while (boundray.up <= boundray.bottom
				|| boundray.left <= boundray.right) {
			num = generateSide(result, num, boundray);
		}
		return result;
	}

	private int generateSide(int[][] matrix, int num, Boundray boundray) {
		switch (side) {
		case UP:
			for (int j = boundray.left; j <= boundray.right; j++) {
				matrix[boundray.up][j] = num;
				num++;
			}
			boundray.up++;
			side = Side.RIGHT;
			break;
		case RIGHT:
			for (int i = boundray.up; i <= boundray.bottom; i++) {
				matrix[i][boundray.right] = num;
				num++;
			}
			boundray.right--;
			side = Side.BOTTOM;
			break;
		case BOTTOM:
			for (int j = boundray.right; j >= boundray.left; j--) {
				matrix[boundray.bottom][j] = num;
				num++;
			}
			boundray.bottom--;
			side = Side.LEFT;
			break;
		case LEFT:
			for (int i = boundray.bottom; i >= boundray.up; i--) {
				matrix[i][boundray.left] = num;
				num++;
			}
			boundray.left++;
			side = Side.UP;
			break;
		default:
			return num;
		}
		return num;
	}
}