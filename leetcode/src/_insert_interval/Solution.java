package _insert_interval;

import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Interval> result = new ArrayList<Interval>();
		boolean hasOverlap = false;
		boolean newIntervalPushed = false;

		if (intervals.isEmpty()) {
			result.add(newInterval);
			return result;
		}

		for (Interval it : intervals) {
			if (newIntervalPushed) {
				result.add(it);
				continue;
			}
			if (isOverlap(it, newInterval)) {
				hasOverlap = true;
				newInterval.start = Math.min(it.start, newInterval.start);
				newInterval.end = Math.max(it.end, newInterval.end);
			}
			// non-overlapping
			else {
				if (hasOverlap) {
					result.add(newInterval);
					result.add(it);
					newIntervalPushed = true;
					continue;
				}
				if (newInterval.start < it.start && !newIntervalPushed) {
					result.add(newInterval);
					result.add(it);
					newIntervalPushed = true;
				} else {
					result.add(it);
				}
			}
		}
		if (!newIntervalPushed) {
			result.add(newInterval);
		}
		return result;
	}

	private boolean isOverlap(Interval inter1, Interval inter2) {
		if (inter1.end < inter2.start || inter2.end < inter1.start) {
			return false;
		}
		return true;
	}
}