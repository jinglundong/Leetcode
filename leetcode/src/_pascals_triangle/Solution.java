package _pascals_triangle;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 *   [ [1], 
 *    [1,1], 
 *   [1,2,1], 
 *  [1,3,3,1], 
 * [1,4,6,4,1] ]
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows < 1) {
			return result;
		}
		result.add(new ArrayList<Integer>());
		result.get(0).add(1);
		for (int i = 1; i < numRows; i++) {
			result.add(new ArrayList<Integer>());
			result.get(i).add(1);
			for (int j = 1; j < i / 2 + 1; j++) { // left half
				result.get(i)
						.add(result.get(i - 1).get(j - 1)
								+ result.get(i - 1).get(j));
			}
			for (int j = i / 2 + 1; j < i + 1; j++) { // right half
				result.get(i).add(result.get(i).get(i - j));
			}
		}
		return result;
	}
}
