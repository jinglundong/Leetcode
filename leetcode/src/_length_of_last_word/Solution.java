package _length_of_last_word;

public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] strAry = s.trim().split(" ");
        return strAry[strAry.length-1].length();
    }
}