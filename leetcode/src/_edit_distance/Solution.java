package _edit_distance;

import java.util.Map;
import java.util.HashMap;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * @author Jinglun
 * 
 */

/**
 * DP, consume from either string(add/delete) or both(replace). 
 * @author Jinglun
 *
 */
public class Solution {
	private String word1;
	private String word2;
	private int word_len1;
	private int word_len2;
	private Map<Integer, Integer> cache;

	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		this.word1 = word1;
		this.word2 = word2;
		word_len1 = word1.length();
		word_len2 = word2.length();
		cache = new HashMap<Integer, Integer>();
		return subMin(0, 0);
	}

	private int subMin(int start1, int start2) {
		int len1 = word_len1 - start1;
		int len2 = word_len2 - start2;
		int cost = 0;
		int result = 0;
		// if one of the string is empty, return the length of the other one
		if (len1 == 0) {
			return len2;
		}
		if (len2 == 0) {
			return len1;
		}
		if (word1.charAt(start1) != word2.charAt(start2)) {
			cost = 1;
		}
		// read from cache
		if (cache.containsKey(start1 * word_len2 + start2)) {
			return cache.get(start1 * word_len2 + start2);
		}
		// return the min among add, delete and replace
		else {
			int tmpMin = Math.min(subMin(start1 + 1, start2),
					subMin(start1, start2 + 1));
			result = Math
					.min(tmpMin + 1, subMin(start1 + 1, start2 + 1) + cost);
			cache.put(start1 * word_len2 + start2, result);
			return result;
		}
	}
}
