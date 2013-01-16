package _interleaving_string;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 * @author jinglun
 * Referance: http://www.cnblogs.com/remlostime/archive/2012/11/25/2787297.html
 * DP
 */
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1 == null || s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        }
        if (s3 == null || s3.length() == 0) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        boolean[][] cache = new boolean[chars1.length + 1][chars2.length + 1];

        // init
        cache[0][0] = true;
        for (int i = 1; i <= chars1.length; i++) {
            cache[i][0] = cache[i - 1][0] && chars1[i - 1] == chars3[i - 1];
        }
        for (int i = 1; i <= chars2.length; i++) {
            cache[0][i] = cache[0][i - 1] && chars2[i - 1] == chars3[i - 1];
        }

        // main loop
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                cache[i][j] = (cache[i - 1][j] && chars1[i - 1] == chars3[i + j
                        - 1])
                        || (cache[i][j - 1] && chars2[j - 1] == chars3[i + j
                                - 1]);
            }
        }
        return cache[chars1.length][chars2.length];
    }

}