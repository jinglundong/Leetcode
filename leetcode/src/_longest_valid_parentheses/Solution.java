package _longest_valid_parentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function

		// use a stack to count the valid panrenthese
		// denote left parentheses as -2, right parenthese as -1 in the stack
		Stack<Integer> stack = new Stack<Integer>();
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (c == '(') {
				stack.push(-2);
				continue;
			}
			// c == ')'
			if (stack.isEmpty()) {
				stack.push(-1);
				continue;
			} else {
				int tmpLen = 0;
				while (!stack.isEmpty()) {
					int top = stack.peek();
					// a left parenthese
					if (top == -2) {
						stack.pop();
						stack.push(tmpLen + 2);
						break;
					}
					// a right parenthese
					if (top == -1) {
						if (tmpLen != 0) {
							stack.push(tmpLen);
						}
						stack.push(-1);
						break;
					}
					// a positive number
					tmpLen += stack.pop();
					if (stack.isEmpty()) {
						stack.push(tmpLen);
						stack.push(-1);
						break;
					}
				}
			}
		}// end for

		return getMaxLen(stack);
	}

	private int getMaxLen(Stack<Integer> stack) {
		int maxLen = 0;
		int curLen = 0;
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (top > 0) {
				curLen += top;
				continue;
			}
			// top < 0
			maxLen = Math.max(maxLen, curLen);
			curLen = 0;
		}
		maxLen = Math.max(maxLen, curLen);
		return maxLen;
	}
}