package _remove_duplicate_from_sorted_arrayII;

import java.util.Map;
import java.util.HashMap;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
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
        int pt1 = 0;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int pt2 = 0; pt2 < A.length; pt2++) {
            int tmp;
            if (count.get(A[pt2]) == null) {
                tmp = 0;
            } else {
                tmp = count.get(A[pt2]);
            }
            if (tmp < 2) {
                A[pt1] = A[pt2];
                pt1++;
                count.put(A[pt2], tmp + 1);
            }
        }
        return pt1;
    }
}