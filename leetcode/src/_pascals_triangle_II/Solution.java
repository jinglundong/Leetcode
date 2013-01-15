package _pascals_triangle_II;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author Jinglun
 * 
 */
public class Solution {

	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();
		// use double to avoid overflow
		double num = 1;
		double row = rowIndex;
		result.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			num = (num * row) / i;
			row--;
			result.add((int) Math.rint(num));
		}
		return result;
	}

}