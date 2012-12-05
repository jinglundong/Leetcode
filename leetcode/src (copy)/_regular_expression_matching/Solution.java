package _regular_expression_matching;

/**
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa", ".*") →
 * true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] char_s = s.toCharArray();
        char[] char_p = p.toCharArray();
        preprocess(char_p);
        return subMatch(char_s, char_p, 0, 0);
    }

    /**
     * reduce the case "a*a*a*" to "a*"
     **/
    private static void preprocess(char[] p) {
        int i = 0;
        while (i < p.length) {
            if (i + 3 < p.length) {
                if (p[i] == p[i + 2] && p[i + 1] == '*' && p[i + 3] == '*') {
                    p[i] = '#';
                    p[i + 1] = '#';
                    i++;
                }
            }
            i++;
        }
    }

    private static boolean subMatch(char[] s, char[] p, int pt_s, int pt_p) {
        if (pt_s == s.length && pt_p == p.length) {
            return true;
        }
        if (pt_p < p.length && p[pt_p] == '#') {
            return subMatch(s, p, pt_s, pt_p + 2);
        }
        if (pt_s == s.length || pt_p == p.length) { // one of the pointers reach
                                                    // the end
            return shift(s, p, pt_s, pt_p);
        }
        if (pt_s < 0 || pt_p < 0) {
            return false;
        }
        if (shift(s, p, pt_s, pt_p)) {
            return true;
        }
        if (reduce(s, p, pt_s, pt_p)) {
            return true;
        }
        return false;
    }

    private static boolean shift(char[] s, char[] p, int pt_s, int pt_p) {
        boolean star = false;
        if (pt_p + 1 < p.length) {
            if (p[pt_p + 1] == '*') {
                star = true;
            }
        }
        if (star) {
            return subMatch(s, p, pt_s, pt_p + 2);
        } else {
            return false;
        }
    }

    private static boolean reduce(char[] s, char[] p, int pt_s, int pt_p) {
        boolean star = false;
        boolean dot = false;
        if (pt_p + 1 < p.length) {
            if (p[pt_p + 1] == '*') {
                star = true;
            }
        }
        if (p[pt_p] == '.') {
            dot = true;
        }
        if (star && dot) {
            return subMatch(s, p, pt_s + 1, pt_p + 2)
                    || subMatch(s, p, pt_s + 1, pt_p);
        }
        if (star) { // star == true, dot == false
            if (s[pt_s] == p[pt_p]) {
                return subMatch(s, p, pt_s + 1, pt_p + 2)
                        || subMatch(s, p, pt_s + 1, pt_p);
            } else {
                return false;
            }
        }
        if (dot) {
            return subMatch(s, p, pt_s + 1, pt_p + 1);
        }
        // star == false, dot ==false
        if (s[pt_s] == p[pt_p]) {
            return subMatch(s, p, pt_s + 1, pt_p + 1);
        } else {
            return false;
        }
    }

}
