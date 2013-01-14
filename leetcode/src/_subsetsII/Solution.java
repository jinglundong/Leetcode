package _subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
    	// DO NOT write main() function
		if (num == null || num.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(num);
		Set<ArrayList<Integer>> prev = new HashSet<ArrayList<Integer>>();
		Set<ArrayList<Integer>> cur = new HashSet<ArrayList<Integer>>();		
		prev.add(new ArrayList<Integer>());
		for (int i = 0; i < num.length; i++) {
			cur.clear();
			for (ArrayList<Integer> list : prev) {
				cur.add(list);
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				for (int j = 0; j < list.size(); j++) {
					tmp.add(list.get(j));
				}
				tmp.add(num[i]);
				cur.add(tmp);
			}
			prev = new HashSet<ArrayList<Integer>>(cur);
		}
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> list : prev){
            result.add(list);
        }
		return result;        
    }
}