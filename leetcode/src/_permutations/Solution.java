package _permutations;

import java.util.ArrayList;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> pre = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
		// init
		for (int i = 0; i < num.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(num[i]);
			pre.add(list);
		}
		for (int i = 1; i < num.length; i++) {
			for (ArrayList<Integer> preIt : pre) {
				for (int numIt : num) {
					if (!preIt.contains(numIt)) {
						ArrayList<Integer> newList = new ArrayList<Integer>(
								preIt);
						newList.add(numIt);
						cur.add(newList);
					}
				}
			}
			pre.clear();
			pre.addAll(cur);
			cur.clear();
		}
		return pre;
	}
}
