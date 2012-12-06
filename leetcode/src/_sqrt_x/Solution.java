package _sqrt_x;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int low = 0;
		int high = 46340; // sqrt(Integer.MAV_VALUE) == 46340.950001051984
		int mid = x / 2;
		if (x >= 46340 * 46340) {
			return 46340;
		}
		while (true) {
			if ((low + 1) * (low + 1) > x && low * low <= x) {
				return low;
			}
			if (high * high <= x && (high + 1) * (high + 1) > x) {
				return high;
			}
			mid = (low + high) / 2;
			if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
				return mid;
			}
			if (mid * mid < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

	}
}
