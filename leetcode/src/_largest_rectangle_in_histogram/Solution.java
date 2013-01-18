package _largest_rectangle_in_histogram;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * @author jinglun
 * Reference: http://blog.csdn.net/dgq8211/article/details/7740610
 */
public class Solution {

    static class BarInfo {
        int w;
        int h;

        public BarInfo(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<BarInfo> stack = new Stack<BarInfo>();
        int result = 0;

        for (int i = 0; i <= height.length; i++) {
            int curr;
            if (i == height.length) {
                curr = 0; // use 0 to flush stack
            } else {
                curr = height[i];
            }
            if (stack.isEmpty() || curr > stack.peek().h) {
                stack.push(new BarInfo(1, curr));
            } else {
                int cumulatedWidth = 0;
                while (!stack.isEmpty() && curr <= stack.peek().h) {
                    BarInfo info = stack.pop();
                    cumulatedWidth += info.w;
                    result = Math.max(result, info.h * cumulatedWidth);
                }
                stack.push(new BarInfo(cumulatedWidth + 1, curr));
            }
        }
        return result;
    }
}
