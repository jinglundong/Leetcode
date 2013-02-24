package _longest_consecutive_sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    class Interval{
        int left;
        int right;
        
        Interval(int left, int right){
            this.left  = left;
            this.right = right;
        }
        
        int getSize(){
            return right-left+1;
        }
    }
    
    enum MergeTo{left, right, both};
    
    private HashSet<Interval> intervals;
    
    private HashMap<Integer, Interval> leftMap;
    
    private HashMap<Integer, Interval> rightMap;
    
    private int result;
    
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        intervals  = new HashSet<Interval>();
        leftMap    = new HashMap<Integer, Interval>();
        rightMap   = new HashMap<Integer, Interval>();
        result     = 0;
        
        if(num == null || num.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        
        //remove duplicate
        for(int it: num){
            set.add(it);
        }
        
        //main loop
        for(int it: set){
            merge(it);
        }
        
        return result;
    }
    
    //side-effects: update result, leftMap, rightMap, intervals
    private void merge(int num){
        ArrayList<Interval> needed = needToMerged(num);
        update(num, needed);
    }
    
    private ArrayList<Interval> needToMerged(int num){
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(leftMap.containsKey(num+1)){
            result.add(leftMap.get(num+1));
        }
        if(rightMap.containsKey(num-1)){
            result.add(rightMap.get(num-1));
        }
        return result;
    }
    
    private void update(int num, ArrayList<Interval> needed){
        switch (needed.size()){
            case 0:
                install(new Interval(num, num));
                break;
            case 1:
                int left  = needed.get(0).left;
                int right = needed.get(0).right;
                uninstall(needed.get(0));
                if(num == left - 1){
                    install(new Interval(num, right));
                }
                else{
                    install(new Interval(left, num));
                }
                break;
            case 2:
                Interval first  = needed.get(0);
                Interval second = needed.get(1);
                uninstall(first );
                uninstall(second);
                install(new Interval(Math.min(first.left, second.left), 
                    Math.max(first.right, second.right)));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    private void install(Interval interval){
        intervals.add(interval);
        leftMap .put(interval.left , interval);
        rightMap.put(interval.right, interval);
        result = Math.max(result, interval.getSize());
    }
    
    private void uninstall(Interval interval){
        leftMap .remove(interval.left );
        rightMap.remove(interval.right);
        intervals.remove(interval);
    }
}