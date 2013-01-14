package _n_queens_ii;

import java.util.ArrayList;

/**
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * Didn't pass the large judge. Using BFS might be a reason, since each iteration need to copy array
 * @author Jinglun
 *
 */
public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //base case
        if(n <=0 || n ==2 || n == 3){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        
        return permutation(n);
    }
    
    private int permutation(int n){
        ArrayList<int[]> prev = new ArrayList<int[]>();
        ArrayList<int[]> cur  = new ArrayList<int[]>();
        
        //init all list to contain one number which is from 0 to n-1
        for(int i=0; i<n; i++){
            int[] tmp = new int[]{i};
            prev.add(tmp);
        }
        
        //assemble permutations from size 2 to n
        for(int i=1; i<n; i++){
            for(int[] array: prev){
                for(int j=0; j<n; j++){
                    if(isValid(array, j, i)){
                        int[] tmp = new int[i+1];
                        System.arraycopy(array, 0, tmp, 0, i);
                        tmp[i] = j;
                        cur.add(tmp);
                    }
                }
            }
            prev = cur;
            cur  = new ArrayList<int[]>();
        }
        return prev.size();
    }
    
    private boolean isValid(int[] array, int n, int size){
        for(int i=0; i<size; i++){
            if (array[i] == n ||                         //list already contains n
                Math.abs(array[i] - n) == size - i){     //conflict on diagonal
    			return false;
    		}
    	}
    	return true;
    }
}