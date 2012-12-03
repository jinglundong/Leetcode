package _set_matrix_zero;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * @author Jinglun
 *AC
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function      
        if (matrix == null){
            return;
        }
        boolean[] rows = new boolean[matrix.length];
        if (matrix.length == 0){
            return;
        }
        boolean[] cols = new boolean[matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (rows[i] || cols[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
