package _spiral_matrix;

import java.util.ArrayList;
/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 * @author Jinglun
 *
 */
public class Solution {
    public enum Side {TOP, RIGHT, BOTTOM, LEFT};
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        int rows = matrix.length;
        if (rows == 0){
            return result;
        }
        int cols = matrix[0].length;
        int left = 0;
        int right = cols-1;
        int top = 0;
        int bottom = rows-1;
        Side cur = Side.TOP;
        
        while(top <= bottom && left <= right){
            switch (cur){
                case TOP:
                    for (int i=left; i<=right; i++){
                        result.add(matrix[top][i]);
                    }
                    top++;
                    cur = Side.RIGHT;
                    break;
                case RIGHT:
                    for (int i=top; i<=bottom; i++){
                        result.add(matrix[i][right]);
                    }
                    right--;
                    cur = Side.BOTTOM;
                    break;
                case BOTTOM:
                    for (int i=right; i>=left; i--){
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;
                    cur = Side.LEFT;
                    break;
                case LEFT:
                    for (int i=bottom; i>=top; i--){
                        result.add(matrix[i][left]);
                    }
                    left++;
                    cur = Side.TOP;
                    break;
                default:
                    ;
            }
        }
        return result;
    }

}