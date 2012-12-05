package _rotate_image_in_place;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null || matrix.length == 0){
            return;
        }
        int rows = matrix.length;   
        int upLeft = 0;
        int bound = rows%2==0? rows/2 : rows/2+1;
        for (int i=0; i<bound; i++){
            for (int j=0; j<bound; j++){
                //for add number of rows, the middle row/col should be processed only once
                if (rows%2 != 0 && i == rows/2){
                    break;
                }
                upLeft = matrix[i][j];      //save upLeft, since it will be override. 
                matrix[i][j] = matrix[rows-1-j][i]; //upLeft = lowLeft
                matrix[rows-1-j][i] = matrix[rows-1-i][rows-1-j];   //lowLeft = lowRight
                matrix[rows-1-i][rows-1-j] = matrix[j][rows-1-i];   //lowRight = upRight
                matrix[j][rows-1-i] = upLeft;   //upRight = upLeft                
            }
        }
    }
}
