package _jump_game;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int rightBound = 0;
		if (A == null || A.length <= 1) {
			return true;
		}
		for (int i = 0; i < A.length; i++) {
			if (i == rightBound && A[i] == 0) {
				return false;
			}
			rightBound = Math.max(rightBound, i + A[i]);
			if (rightBound >= A.length - 1) {
				return true;
			}
		}
		return true;
	}
}
