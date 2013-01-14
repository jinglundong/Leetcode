package _valid_number;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true Note: It is intended for the problem statement to be
 * ambiguous. You should gather all requirements up front before implementing
 * one.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// \\s*[-|+]? heading white space and sign
		// (\\d+\\.?|\\.?\\d+|\\d+\\.\\d+) three cases of actual number
		// (e[-|+]?\\d+)?\\s* exponential part
		return s.matches("\\s*[-|+]?(\\d+\\.?|\\.?\\d+|\\d+\\.\\d+)(e[-|+]?\\d+)?\\s*");
	}
}
