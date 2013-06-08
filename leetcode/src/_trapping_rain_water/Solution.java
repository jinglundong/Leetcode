package _trapping_rain_water;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	private int[] A;
	private Stack<Integer> stack;
	private int result;

	public int trap(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		stack = new Stack<Integer>();
		this.A = A;
		result = 0;
		if (A == null || A.length <= 2) {
			return 0;
		}
		stack.push(0);
		for (int i = 1; i < A.length; i++) {
			trapHelper(i);
		}
		return result;
	}

	private void trapHelper(int index) {
		int prev = stack.peek();
		int prevH = 0;
		while (!stack.isEmpty() && A[prev] <= A[index]) {
			result += (index - prev - 1) * (A[prev] - prevH);
			prevH = A[prev];
			stack.pop();
			if (!stack.isEmpty()) {
				prev = stack.peek();
			}
		}
		if (!stack.isEmpty() && A[prev] > A[index]) {
			result += (index - prev - 1) * (A[index] - prevH);
		}
		stack.push(index);

	}

}