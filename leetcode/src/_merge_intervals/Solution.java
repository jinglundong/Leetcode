package _merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    //comparator for interval, sort by start first, 
    //if two intervals start with the same number,
    //sort by their ends
    public class MyIntComparable implements Comparator<Interval>{
        @Override
	    public int compare(Interval o1, Interval o2) {
	    	if (o1.start < o2.start){
	    		return -1;
	    	}
	    	if (o1.start > o2.start){
	    		return 1;
	    	}
	        return (o1.end<o2.end ? -1 : (o1.end==o2.end ? 0 : 1));
	    }
	}
    
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //assume there is no two intervals start with the same number
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.isEmpty()){
            return result;
        }
        
        //a list of start of all intervals
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.addAll(intervals);
        
        Collections.sort(list, new MyIntComparable());
        
        //base case
        int newStart = list.get(0).start;
        int newEnd = list.get(0).end;
        
        //main loop
        for(int i=1; i<list.size(); i++){
            int start = list.get(i).start;
            if(start <= newEnd){
                newEnd = Math.max(list.get(i).end, newEnd);    
            }
            else{
                Interval newInterval = new Interval(newStart, newEnd);
                result.add(newInterval);

                newStart = list.get(i).start;
                newEnd   = list.get(i).end;
                
            }
        }
        
        //flush the last interval
        Interval newInterval = new Interval(newStart, newEnd);
        result.add(newInterval);
        return result;
    }
}
