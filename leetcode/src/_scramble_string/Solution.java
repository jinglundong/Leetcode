package _scramble_string;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * @author jinglun
 * 
 * Reference: http://heartfire.cc/wp/scramble-string/
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s1.length();
        if (n == 1) {
            return s1.equals(s2);
        }
        if (n != s2.length()) {
            return false;
        }
        for (int i = 1; i <= n / 2; i++) {
            String s1LeftShort = s1.substring(0, i);
            String s1RightShort = s1.substring(n - i);
            String s1LeftLong = s1.substring(0, n - i);
            String s1RightLong = s1.substring(i);

            String s2LeftShort = s2.substring(0, i);
            String s2RightShort = s2.substring(n - i);
            String s2LeftLong = s2.substring(0, n - i);
            String s2RightLong = s2.substring(i);

            if (isScramble(s1LeftShort, s2LeftShort)
                    && isScramble(s1RightLong, s2RightLong))
                return true;
            if (isScramble(s1RightShort, s2RightShort)
                    && isScramble(s1LeftLong, s2LeftLong))
                return true;
            if (isScramble(s1LeftShort, s2RightShort)
                    && isScramble(s1RightLong, s2LeftLong))
                return true;
            if (isScramble(s1RightShort, s2LeftShort)
                    && isScramble(s1LeftLong, s2RightLong))
                return true;
        }
        return false;
    }
}
