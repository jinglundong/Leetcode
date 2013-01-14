package _triangle;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 	
 * @author Jinglun
 * 
 */
public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (triangle == null) {
			return 0;
		}
		ArrayList<Integer> tmp = new ArrayList<Integer>(triangle.get(triangle
				.size() - 1));
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				tmp.set(j,
						triangle.get(i).get(j)
								+ Math.min(tmp.get(j), tmp.get(j + 1)));
			}
		}
		return tmp.get(0);
	}
}
