package _permutationsII;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> pre = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
        Map<Integer, Integer> numCount = new HashMap<Integer,Integer>();
        if (num == null || num.length ==0){
            return pre;
        }
        //a map that mapping a number within int[] num to the count of it
        for(int n : num){
            if (numCount.containsKey(n)){
                numCount.put(n,numCount.get(n)+1);
            }
            else{
                numCount.put(n,1);
            }
        }
		// init
		for (int i: numCount.keySet()) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			pre.add(list);
		}
        //main loop
		for (int i = 1; i < num.length; i++) {
			for (ArrayList<Integer> preIt : pre) {
				for (int numIt : numCount.keySet()) {
					if (numCount.get(numIt) > countNum(preIt, numIt)) {
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
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(pre);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.addAll(set);
		return result;
    }
    
    //return the frequency of the given number within a list
    private int countNum(ArrayList<Integer> list, int num){
        int count = 0;
        for(int it: list){
            if(it == num){
                count++;
            }
        }
        return count;
    }
}