package _simplify_path;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Deque<String> deque = new LinkedList<String>();
        String[] paths = path.split("/");
        for (String str : paths) {
            if (str.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
                continue;
            }
            if (str.length() == 0 || str.equals(".")) {
                continue;
            }
            deque.addLast(str);
        }
        StringBuffer buffer = new StringBuffer();
        if (deque.isEmpty()) {
            return "/";
        }
        while (!deque.isEmpty()) {
            buffer.append("/");
            buffer.append(deque.pop());
        }
        return buffer.toString();
    }
}
