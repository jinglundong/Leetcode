package _min_path_sum;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * @author Jinglun
 *AC
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        if (grid == null){
            return 0;            
        }
        if (grid.length == 0){
            return 0;
        }
        int[][] cache = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                cache[i][j] = -1;
            }
        }
        return minPathSub(grid, 0, 0, cache);
    }
    
    public static int minPathSub(int[][] grid, int row, int col, int[][] cache){
        if (row == grid.length-1 && col == grid[0].length-1){
            cache[row][col] = grid[row][col];
            return grid[row][col];
        }
        if (row >= grid.length || col >= grid[0].length){
            return Integer.MAX_VALUE;
        }        
        int down;        
        int right;    
        if (row < grid.length-1){
            if ( cache[row+1][col] == -1){
                down = minPathSub(grid, row+1, col, cache);
                cache[row+1][col] = down;
            }
            else{
                down = cache[row+1][col];
            }
        }
        else{
            down = Integer.MAX_VALUE;
        }
        if (col < grid[0].length-1){
            if ( cache[row][col+1] == -1){
                right = minPathSub(grid, row, col+1, cache);
                cache[row][col+1] = right;
            }
            else{
                right = cache[row][col+1];
            }
        }
        else{
            right = Integer.MAX_VALUE;
        }
        return Math.min(right, down) + grid[row][col];
    }
}