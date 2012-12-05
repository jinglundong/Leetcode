package _restore_ip;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Set<String> result = validIp(s, 4);
        ArrayList<String> list = new ArrayList<String>();
        for (String it : result) {
            list.add(it);
        }
        return list;
    }

    // ip is partial parsed ip
    private static Set<String> validIp(String s, int blockLeft) {
        Set<String> result = new HashSet<String>();
        if (blockLeft == 0) {
            return result;
        }
        if (blockLeft == 1) {
            if (isValidBlock(s)) {
                result.add(s);
                return result;
            }
            return result;
        }
        // check one to three digits each time
        for (int i = 1; i <= 3; i++) {
            checkDifLength(s, i, result, blockLeft);
        }
        return result;
    }

    /**
     * Check valid ip with different length of first block
     **/
    private static void checkDifLength(String s, int digit, Set<String> result,
            int blockLeft) {
        if (s.length() > digit - 1 && isValidBlock(s.substring(0, digit))) {
            Set<String> subResult = validIp(s.substring(digit), blockLeft - 1);
            for (String it : subResult) {
                result.add(concat(s, digit, it));
            }
        }
    }

    private static String concat(String s, int digit, String subString) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(s.substring(0, digit));
        buffer.append(".");
        buffer.append(subString);
        return buffer.toString();
    }

    private static boolean isValidBlock(String str) {
        if (str.length() <= 0 || str.length() > 3) {
            return false;
        }
        int num = Integer.parseInt(str);
        if (num < 0 || num > 255) {
            return false;
        }
        if (str.matches("0\\d+")) { // 001 is invalid format
            return false;
        }
        return true;
    }
}