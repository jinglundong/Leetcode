package _jump_game_II;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int jump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length <= 1) {
			return 0;
		}
		int[] best = new int[A.length];
		for (int i = A.length - 2; i >= 0; i--) {
			if (i + A[i] >= A.length - 1) {
				best[i] = 1;
			} else {
				int localBest = Integer.MAX_VALUE;
				for (int j = i + 1; j <= i + A[i]; j++) {
					localBest = Math.min(localBest, best[j]);
				}
				int foundBetter;
				foundBetter = (localBest == Integer.MAX_VALUE) ? 0 : 1;
				best[i] = localBest + foundBetter;
			}
		}
		return best[0];
	}
}
