package _remove_duplicate_from_sorted_array;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        if (A == null) {
            return 0;
        }
        if (A.length == 0) {
            return 0;
        }
        int previous = A[0];
        int pt1 = 1;
        for (int pt2 = 1; pt2 < A.length; pt2++) {
            if (A[pt2] != previous) {
                A[pt1] = A[pt2];
                previous = A[pt1];
                pt1++;
            }
        }
        return pt1;
    }
}