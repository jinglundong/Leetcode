package _word_search;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pos other = (Pos) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }
    
    private LinkedList<Pos> visited;
    private String word;
    private char[][] board;
    private int wordLen;
    private int boardH;
    private int boardW;   
    
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.visited = new LinkedList<Pos>();
        this.word = word;
        this.board = board;
        this.wordLen = word.length();
        this.boardH = board.length;
        this.boardW = board[0].length;
        
        if(word.length() == 0){
            return true;
        }
        if(wordLen > boardH * boardW){
            return false;
        }
        if(!checkCharNum()){
            return false;
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited.addLast(new Pos(i,j));
                    if(exist(1)){
                        return true;
                    }
                    visited.pop();
                }
            }
        }
        return false;
    }
    
    private boolean checkCharNum(){
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for(char[] ary: board){
            for(char c: ary){
                if(!count.containsKey(c)){
                    count.put(c, 1);
                }
                else{
                    count.put(c, count.get(c)+1);
                }
            }
        }
        for(char c: word.toCharArray()){
            if(!count.containsKey(c)){
                return false;
            }
            int charCount = count.get(c);
            if(charCount-1 < 0){
                return false;
            }
            count.put(c, charCount-1);
        }
        return true;
    }
    
    private boolean exist(Pos pos, int wordIndex){
        int x = pos.x;
        int y = pos.y;
        if(x < 0 || x >= boardH || y < 0 || y >= boardW){
            return false;
        }
        if(!visited.contains(pos) && word.charAt(wordIndex) == board[x][y]){
            if(wordIndex >= wordLen - 1){
                return true;
            }
            visited.addLast(pos);
            if(exist(wordIndex+1)){
                return true;
            }
            visited.pop();
        }
        return false;
    }
    
    private boolean exist(int start){
        if(start > wordLen - 1){
            return true;
        }
        Pos prev = visited.peekLast();
        int x = prev.x;
        int y = prev.y;
        if(exist(new Pos(x, y-1), start)){
            return true;
        }
        if(exist(new Pos(x, y+1), start)){
            return true;
        }
        if(exist(new Pos(x-1, y), start)){
            return true;
        }
        if(exist(new Pos(x+1, y), start)){
            return true;
        }
        return false;
    }
}