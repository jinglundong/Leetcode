package _search_for_a_range;

import java.lang.IllegalArgumentException.*;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        result[0] = hit(A, target, 0, A.length-1, true);
        result[1] = hit(A, target, 0, A.length-1, false);
        return result;
    }
    
    /**
     * binary search, find the boundary of range.
     * find left boundary if findLeft is true. Find right one if findLeft is false.
     **/
    private int hit(int[] A, int target, int low, int high, boolean findLeft){
        if (A == null || A.length == 0){
            return -1;
        }
        if (low < 0 || high >= A.length){
            throw new IllegalArgumentException();
        }
        while(low <= high){ 
            //test boundary.
            if (findLeft && low == 0 && A[low] == target){
                return low;
            }
            if (!findLeft && high == A.length-1 && A[high] == target){
                return high;
            }
            if (findLeft && low-1>=0 && A[low-1] != target && A[low] == target){
                return low;
            } 
            if (!findLeft && high+1<A.length && A[high+1] != target && A[high] == target){
                return high;
            }
            //test mid
            int mid = low + (high - low)/2;            
            if (A[mid] == target){  //mid is in the range
                if (findLeft){
                    if (A[mid-1] != target){        //left boundary
                        return mid;
                    }
                    else{
                        return hit(A, target, low, mid-1, findLeft);
                    }
                }
                else{       //find right boundary
                    if (A[mid+1] != target){
                        return mid;
                    }
                    else{
                        return hit(A, target, mid+1, high, findLeft);
                    }
                }
            }
            else{
                if (A[mid] < target){
                    return hit(A, target, mid+1, high, findLeft);
                }
                else{
                    return hit(A, target, low, mid-1, findLeft);
                }
            }              
            
        }
        return -1;
    }
}
