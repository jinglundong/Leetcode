package _valid_palindrome;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0) {
			return true;
		}
		s = s.toLowerCase();
		char[] chars = s.toCharArray();
		int length = chars.length;
		int l = 0;
		int r = chars.length - 1;
		while (l < r) {
			while (!isValidChar(chars[l])) {
				if (l + 1 < length) {
					l++;
				} else {
					break;
				}
			}
			while (!isValidChar(chars[r])) {
				if (r - 1 >= 0) {
					r--;
				} else {
					break;
				}
			}
			if (l >= r || (r == 0 && l == length - 1)) {
				return true;
			}
			if (chars[l] != chars[r] || !isValidChar(chars[l])) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	private boolean isValidChar(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		if (c >= 'a' && c <= 'z') {
			return true;
		}
		return false;
	}
}