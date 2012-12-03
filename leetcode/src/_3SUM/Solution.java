package _3SUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	/**
	 * AC
	 * @param num
	 * @return
	 */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(num);
		if (num.length < 3 || num == null) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int twoSumIndex = num.length - 1; twoSumIndex >= 2; twoSumIndex--) {
			int aim = num[twoSumIndex];
			int l = 0;
			int r = twoSumIndex - 1;
			while (l < r ) {
				if (num[l] + num[r] == -1 * aim) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.clear();
					tmp.add(num[l]);
					tmp.add(num[r]);
					tmp.add(aim);
					addToList(result, tmp);
					l++;
				} else {
					if (num[l] + num[r] < -1 * aim) {
						l++;
					} else {
						r--;
					}
				}
                if (aim < 0){
                    break;
                }
			}
		}		
		return result;
	}

	public void addToList(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> in) {
    	for (int i = result.size()-1; i >= 0 ; i--) {
			if (result.get(i).get(2) == in.get(2)){
				if (result.get(i).get(1) == in.get(1) && result.get(i).get(0) == in.get(0)) {
					return;
				}
			}
		}
		result.add(in);
	}
	
	public static void main(String[] args) {
		Stack<Integer> queue = new Stack<Integer>();
	}
}
