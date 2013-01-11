package _implement_strStr;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int haystackSize = haystack.length();
        int needleSize = needle.length();
        int bound = haystackSize - needleSize + 1;
        for (int i = 0; i < bound; i++) {
            if (haystack.substring(i, i + needleSize).equals(needle)) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}