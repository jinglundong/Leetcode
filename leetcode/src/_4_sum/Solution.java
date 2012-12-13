package _4_sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
    
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //key of sumMap is sum of two numbers
        //ArrayList store lists of sets that contains indexes
        Map<Integer, ArrayList<HashSet<Integer>>> sumMap 
            = new HashMap<Integer, ArrayList<HashSet<Integer>>>();
        Set<ArrayList<Integer>> tmpResult = new HashSet<ArrayList<Integer>>();
        for (int i=0; i<num.length; i++){
            for (int j=i+1; j<num.length; j++){
                HashSet<Integer> tmpSet = new HashSet<Integer>();
                tmpSet.add(i);
                tmpSet.add(j);
                if (!sumMap.containsKey(num[i] + num[j])){                    
                    ArrayList<HashSet<Integer>> tmpList = new ArrayList<HashSet<Integer>>();
                    tmpList.add(tmpSet);
                    sumMap.put(num[i]+num[j], tmpList);
                }
                else{                    
                    sumMap.get(num[i]+num[j]).add(tmpSet);                
                }
            }
        }
        Set<Integer> keySet = sumMap.keySet();
        ArrayList<Integer> keyList = new ArrayList<Integer>(keySet);
        Collections.sort(keyList);
        //for each pair of two sum, check if they sum to target
        int it1 = 0;
        int it2 = keyList.size()-1;
        while(it1<=it2){        
            int sum1 = keyList.get(it1);    //first two numbers       
            int sum2 = keyList.get(it2);    //the other two numbers
            //hit
            if (sum1+sum2 == target){       
                ArrayList<HashSet<Integer>> list1 = sumMap.get(sum1);
                ArrayList<HashSet<Integer>> list2 = sumMap.get(sum2);
                for (HashSet<Integer> set1: list1){
                    for (HashSet<Integer> set2: list2){
                        Set<Integer> tmpSet = new HashSet<Integer>(set1);
                        tmpSet.addAll(set2);
                        if (tmpSet.size() == 4){
                            ArrayList<Integer> sortedList = 
                                new ArrayList<Integer>();
                            for (Integer it: tmpSet){
                                sortedList.add(num[it]);
                            }
                            Collections.sort(sortedList);
                            tmpResult.add(sortedList);
                        }
                    }
                }
                it1++;
                it2--;
                continue;
            }
            //less than target
            if (sum1+sum2 < target){
                it1++;
            }
            //larger than target
            else{
                it2--;
            }
            
        }        
        return new ArrayList<ArrayList<Integer>>(tmpResult);
    }
}
