package _generate_parentheses;

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	private ArrayList<String> result;

	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		result = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		generateParenthesisHelper(n, n, buffer);
		return result;
	}

	private void generateParenthesisHelper(int numLeft, int numRight,
			StringBuffer buffer) {
		if (numLeft == 0 && numRight == 0) {
			result.add(buffer.toString());
			return;
		}
		if (numLeft > numRight)
			return; // or throw exceptions
		if (numLeft <= 0) {
			buffer.append(")");
			generateParenthesisHelper(0, numRight - 1, buffer);
		} else {
			StringBuffer other = new StringBuffer(buffer);
			other.append("(");
			generateParenthesisHelper(numLeft - 1, numRight, other);
			buffer.append(")");
			generateParenthesisHelper(numLeft, numRight - 1, buffer);
		}
	}
}