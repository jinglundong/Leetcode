package _surrounded_regions;

/**
 * Doesn't pass large test set
 * @author jinglun
 *
 */
public class Solution {
    
    private char[][] board;
    
    private int total_row;
    
    private int total_col;
    
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board == null || board.length == 0 || board[0] == null){
            return;
        }
        
        this.board = board;
        this.total_row = board.length;
        this.total_col = board[0].length;
        
        for(int row=0; row<total_row; row++){
            expand(row, 0                );
            expand(row, total_col-1);
        }
        for(int col=0; col<total_col-1; col++){
            expand(0             , col);
            expand(total_row-1, col);
        }
        clean();
    }
    
    private void expand(int row, int col){
        if(row < 0 || col < 0 ||
            row >= total_row || col >= total_col){
            return;
        }
        switch (board[row][col]){
            case 'X':
                break;
            case 'O':
                board[row][col] = 'K';  //means keep as 'O'
                expand(row-1, col  );
                expand(row+1, col  );
                expand(row  , col-1);
                expand(row  , col+1);
                break;
            case 'K':
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    private void clean(){
        
    }
    private void clean1(){
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if (board[row][col] != 'K'){
                    board[row][col] = 'X';
                }
            }
        }
        
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if (board[row][col] != 'X'){
                    board[row][col] = 'O';
                }
            }
        }
    }
}