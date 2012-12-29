package _combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7] [2,
 * 2, 3]
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	private Map<Integer, HashSet<ArrayList<Integer>>> map;
	private int[] candidates;

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		map = new HashMap<Integer, HashSet<ArrayList<Integer>>>();
		Arrays.sort(candidates);
		this.candidates = candidates;

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
						tmp.add(i);
						Collections.sort(tmp);
						map.get(target).add(tmp);
					}
				}
			}
		}
	}
}
