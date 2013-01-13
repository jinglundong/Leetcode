package _longest_substring_without_repeating_characters;

import java.util.Set;
import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.isEmpty()) {
			return 0;
		}
		char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		int maxLen = 0;
		int left = 0;
		int right = 0;
		int sLen = s.length();

		while (right < sLen) {
			if (!set.contains(chars[right])) {
				set.add(chars[right]);
				right++;
			} else {
				maxLen = Math.max(maxLen, right - left);
				while (chars[left] != chars[right]) {
					set.remove(chars[left]);
					left++;
				}
				left++;
				right++;
			}
		}
		// flush the last one
		maxLen = Math.max(maxLen, right - left);
		return maxLen;
	}
}