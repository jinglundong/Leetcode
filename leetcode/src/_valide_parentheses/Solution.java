package _valide_parentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Deque<Character> queue = new LinkedList();
		char[] charArray = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (queue.isEmpty()) {
				if (charArray[i] == '(' || charArray[i] == '{'
						|| charArray[i] == '[') {
					queue.addLast(charArray[i]);
				} else {
					return false;
				}
			} else {
				if (charArray[i] == '(' || charArray[i] == '{'
						|| charArray[i] == '[') {
					queue.addLast(charArray[i]);
				} else {
					switch (charArray[i]) {
					case ')':
						if (queue.pollLast() != '(') {
							return false;
						}
						break;
					case '}':
						if (queue.pollLast() != '{') {
							return false;
						}
						break;
					case ']':
						if (queue.pollLast() != '[') {
							return false;
						}
						break;
					default:
						return false;
					}
				}

			}
		}
		if (!queue.isEmpty()) {
			return false;
		}
		return true;
	}
}