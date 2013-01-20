package _search_insert_position;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. 
 * [1,3,5,6], 5 -> 2 
 * [1,3,5,6], 2 -> 1 
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 * 
 * @author Jinglun
 * 
 * Binary search
 */
public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0){
            return 0;
        }
        if(A[0] >= target){
            return 0;
        }
        int left  = 1;
        int right = A.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(A[mid-1] < target && A[mid] >= target){
                return mid;
            }
            if(target <= A[mid-1]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return A.length;
    }
}