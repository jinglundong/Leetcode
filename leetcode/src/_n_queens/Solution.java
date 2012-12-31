package _n_queens;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
import java.util.ArrayList;

public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> perm;
		ArrayList<String[]> result = new ArrayList<String[]>();

		// base case
		if (n <= 0 || n == 2 || n == 3) {
			return result;
		}
		if (n == 1) {
			String[] strArray = new String[1];
			strArray[0] = "Q";
			result.add(strArray);
			return result;
		}

		// start to compute all valid permutation of n
		perm = permutation(n);

		// print valid solution
		return toString(perm);
	}

	private ArrayList<ArrayList<Integer>> permutation(int n) {
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();

		// init all list to contain one number which is from 0 to n-1
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(i);
			prev.add(tmp);
		}

		// assemble permutations from size 2 to n
		for (int i = 1; i < n; i++) {
			for (ArrayList<Integer> list : prev) {
				for (int j = 0; j < n; j++) {
					if (isValid(list, j)) {
						ArrayList<Integer> tmpValid = new ArrayList<Integer>();
						tmpValid.addAll(list);
						tmpValid.add(j);
						cur.add(tmpValid);
					}
				}
			}
			prev = cur;
			cur = new ArrayList<ArrayList<Integer>>();
		}
		return prev;
	}

	private boolean isValid(ArrayList<Integer> list, int n) {
		int size = list.size();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == n || // list already contains n
					Math.abs(list.get(i) - n) == size - i) { // conflict on
																// diagonal
				return false;
			}
		}
		return true;
	}

	private ArrayList<String[]> toString(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		for (ArrayList<Integer> list : lists) {
			int lineNum = 0;
			String[] lines = new String[list.size()];
			for (int i : list) {
				StringBuffer line = new StringBuffer();
				for (int j = 0; j < list.size(); j++) {
					if (i == j) {
						line.append("Q");
					} else {
						line.append(".");
					}
				}
				lines[lineNum] = line.toString();
				lineNum++;
			}
			result.add(lines);
		}
		return result;
	}
}