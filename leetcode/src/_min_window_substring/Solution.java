package _min_window_substring;

import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String result = "";
        Deque<Integer> queue = new ArrayDeque<Integer>();
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        if (T.isEmpty() || S.isEmpty()) {
            return "";
        }
        for (int i = 0; i < T.length(); i++) {
            if (!charCount.containsKey(T.charAt(i))) {
                charCount.put(T.charAt(i), 1);
            } else {
                charCount.put(T.charAt(i), charCount.get(T.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            if (charCount.containsKey(S.charAt(i))) {
                charCount.put(S.charAt(i), charCount.get(S.charAt(i)) - 1);
                queue.add(i);
            }
            if (isAllNonPositive(charCount)) {
                int first = queue.peekFirst();
                if (result.isEmpty()) {
                    result = S.substring(first, queue.peekLast() + 1);
                    charCount.put(S.charAt(first),
                            charCount.get(S.charAt(first)) + 1);
                    queue.pollFirst();
                } else {
                    if (i - first + 1 < result.length()) {
                        result = S.substring(first, queue.peekLast() + 1);
                        charCount.put(S.charAt(first),
                                charCount.get(S.charAt(first)) + 1);
                        queue.pollFirst();
                    }
                }
                while (isAllNonPositive(charCount)) {
                    first = queue.peekFirst();
                    if (i - first + 1 <= result.length()) {
                        result = S.substring(first, queue.peekLast() + 1);
                    }
                    charCount.put(S.charAt(first),
                            charCount.get(S.charAt(first)) + 1);
                    queue.pollFirst();
                }
            }
        }
        return result;
    }

    private static boolean isAllNonPositive(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> it : map.entrySet()) {
            if (it.getValue() > 0) {
                return false;
            }
        }
        return true;
    }
}
