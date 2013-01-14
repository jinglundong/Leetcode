package _container_with_most_water;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int result = 0;
		if (height == null) {
			return 0;
		}
		int leftMax = 0;
		int rightMax = 0;
		int i = 0;
		int j = height.length - 1;
		while (i < j && i < height.length - 1 && j > 0) {
			// if left height is less than running max of left line, check the
			// next from left
			if (height[i] < leftMax) {
				i++;
				continue;
			}
			leftMax = height[i];
			// if right height is less than running max of right line, check the
			// next from right
			if (height[j] < rightMax) {
				j--;
				continue;
			}
			rightMax = height[j];
			// calculate the current volume, update result if it is larger than
			// previous maximum
			int tmpVolume = Math.min(height[i], height[j]) * (j - i);
			result = Math.max(result, tmpVolume);
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return result;
	}
}
