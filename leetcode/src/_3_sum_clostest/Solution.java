package _3_sum_clostest;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length < 3) {
			throw new IllegalArgumentException();
		}
		Arrays.sort(num);
		int result = num[0] + num[1] + num[2];
		for (int i = num.length - 1; i >= 0; i--) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				if (Math.abs(num[left] + num[right] + num[i] - target) < Math
						.abs(result - target)) {
					result = num[left] + num[right] + num[i];
					if (result == target) {
						return result;
					}
				}
				if (num[left] + num[right] + num[i] < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
}