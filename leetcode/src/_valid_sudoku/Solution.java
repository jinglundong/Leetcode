package _valid_sudoku;

import java.util.Set;
import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public boolean isValidSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// Check rows and cols
		for (int i = 0; i < 9; i++) {
			Set<Character> countRow = new HashSet<Character>();
			Set<Character> countCol = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!countRow.contains(board[i][j])) {
						countRow.add(board[i][j]);
					} else {
						return false;
					}
				}
				if (board[j][i] != '.') {
					if (!countCol.contains(board[j][i])) {
						countCol.add(board[j][i]);
					} else {
						return false;
					}
				}
			}
		}
		// check blocks
		for (int row = 0; row < 9; row += 3) {
			for (int col = 0; col < 9; col += 3) {
				Set<Character> countBlock = new HashSet<Character>();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (board[row + i][col + j] != '.') {
							if (!countBlock.contains(board[row + i][col + j])) {
								countBlock.add(board[row + i][col + j]);
							} else {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}
