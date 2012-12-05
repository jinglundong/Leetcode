package _remove_element;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pt1 = 0;
        int pt2 = A.length - 1;
        while (pt1 <= pt2) {
            if (A[pt1] == elem) {
                if (A[pt2] != elem) {
                    A[pt1] = A[pt2];
                    pt1++;
                    pt2--;
                } else {
                    pt2--;
                }
            } else {
                pt1++;
            }
        }
        return pt2 + 1;
    }
}
