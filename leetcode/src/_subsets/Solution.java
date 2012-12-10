package _subsets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author Jinglun
 * 
 */

public class Solution {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S == null || S.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();		
		prev.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			cur.clear();
			for (ArrayList<Integer> list : prev) {
				cur.add(list);
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				for (int j = 0; j < list.size(); j++) {
					tmp.add(list.get(j));
				}
				tmp.add(S[i]);
				cur.add(tmp);
			}
			prev = new ArrayList<ArrayList<Integer>>(cur);
		}
		return prev;
	}
}