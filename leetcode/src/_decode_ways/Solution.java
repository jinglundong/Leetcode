package _decode_ways;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int[] cache = new int[s.length() + 1];
		for (int i = 0; i < cache.length; i++) {
			cache[i] = -1;
		}
		return subDecoding(s, 0, cache);
	}

	private int subDecoding(String s, int start, int[] cache) {
		if (start >= s.length()) {
			return 1;
		}
		if (start == s.length() - 1) {
			if (s.charAt(start) - '0' > 0) {
				return 1;
			}
			return 0;
		}
		if (s.charAt(start) == '0') {
			return 0;
		}
		// shift1 denotes the way of decoding from character start+1
		int shift1 = cache[start + 1];
		int shift2 = cache[start + 2];
		if (shift1 == -1) {
			cache[start + 1] = subDecoding(s, start + 1, cache);
			shift1 = cache[start + 1];
		}
		if (shift2 == -1) {
			cache[start + 2] = subDecoding(s, start + 2, cache);
			shift2 = cache[start + 2];
		}
		if (s.charAt(start) == '1') {
			return shift1 + shift2;
		}
		// 20 - 26 are valid two digits number start with '2'
		if (s.charAt(start) == '2' && s.charAt(start + 1) - '0' < 7) {
			return shift1 + shift2;
		}
		return shift1;

	}
}
