package _reverse_integer;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String sign = "";
		if (x < 0) {
			sign = "-";
			x = -1 * x;
		}
		StringBuffer buffer = new StringBuffer(String.valueOf(x));
		return Integer.parseInt(sign + buffer.reverse().toString());
	}
}
