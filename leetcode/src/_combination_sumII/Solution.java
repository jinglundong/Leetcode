package _combination_sumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 <= a2 <=
 * � <= ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	private Map<Integer, HashSet<ArrayList<Integer>>> map;
	private Map<Integer, Integer> count;
	private int[] candidates;

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// init
		map = new HashMap<Integer, HashSet<ArrayList<Integer>>>();
		Arrays.sort(candidates);
		this.candidates = candidates;
		count = new HashMap<Integer, Integer>();
		for (int i : candidates) {
			if (count.containsKey(i)) {
				count.put(i, count.get(i) + 1);
			} else {
				count.put(i, 1);
			}
		}

		// main recursion
		subCombination(target);
		ArrayList<ArrayList<Integer>> finalResult = new ArrayList<ArrayList<Integer>>();
		if (map.get(target) != null) {
			finalResult.addAll(map.get(target));
		}
		return finalResult;
	}

	private void subCombination(int target) {
		if (map.get(target) == null) {
			map.put(target, new HashSet<ArrayList<Integer>>());
			for (int i : candidates) {
				if (target - i < 0) {
					break;
				}
				if (target == i) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(i);
					map.get(target).add(tmp);
					break;
				}
				// get result for target from target-i
				subCombination(target - i);
				if (map.get(target - i) != null
						&& !map.get(target - i).isEmpty()) {
					for (ArrayList<Integer> list : map.get(target - i)) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.addAll(list);
						if (countFreq(list, i) >= count.get(i)) {
							continue;
						}
						tmp.add(i);
						Collections.sort(tmp);
						map.get(target).add(tmp);
					}
				}
			}
		}
	}

	private int countFreq(ArrayList<Integer> list, int num) {
		int count = 0;
		for (int i : list) {
			if (i == num) {
				count++;
			}
		}
		return count;
	}
}
