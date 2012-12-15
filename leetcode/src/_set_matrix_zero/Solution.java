package _set_matrix_zero;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * @author Jinglun
 * follow up: use constant space.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean isFirstRowAllZero = false;
        boolean isFirstColAllZero = false;
        if (matrix == null){
            return;
        }
        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){                
                if (matrix[i][j] == 0){
                    if (i==0){
                        isFirstRowAllZero = true;
                    }
                    if (j==0){
                        isFirstColAllZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<matrix.length; i++){
            if (matrix[i][0] == 0){
                for (int j=1; j<matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=1; j<matrix[0].length; j++){
            if (matrix[0][j] == 0){
                for (int i=1; i<matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if (isFirstRowAllZero){
            for (int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }        
        if (isFirstColAllZero){
            for (int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }        
        
    }
}