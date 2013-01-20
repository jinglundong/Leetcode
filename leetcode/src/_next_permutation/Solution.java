package _next_permutation;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 
 * 1,2,3 -> 1,3,2 
 * 3,2,1 -> 1,2,3 
 * 1,1,5 -> 1,5,1
 * 
 * @author Jinglun
 * 
 */
public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = getFirstDec(num);
        if(left < 0){
            reverse(num);
            return;
        }
        swap(left, num);
        sort(left+1, num);
    }
    
    private void reverse(int[] num){
        if(num == null || num.length <= 1){
            return;
        }
        for(int i=0; i<num.length/2; i++){
            int tmp = num[i];
            num[i] = num[num.length - i - 1];
            num[num.length - i - 1] = tmp;
        }
    }
    
    private void swap(int left, int[] num){
        int right = left+1;
        for(int i=num.length-1; i>left; i--){
            if(num[i] > num[left] && num[i] < num[right]){
                right = i;
            }
        }
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
    }
    
    private void sort(int index, int[] num){
        Arrays.sort(num, index, num.length);
    }
    
    private int getFirstDec(int[] num){
        for(int i=num.length -1; i>=1; i--){
            if(num[i] > num[i-1]){
                return i-1;
            }
        }
        return -1;
    }
}
	
	

