package _gray_code;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 
 * 01 - 1 
 * 11 - 3 
 * 10 - 2
 * 
 * @author jinglun
 * 
 */
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < (1 << n); i++) {
            int tmpInt = 0;
            for (int power = 0; power < n; power++) {
                tmpInt += ((i + (1 << power)) / (1 << (power + 1)) % 2 * (1 << power));
            }
            result.add(tmpInt);
        }
        return result;
    }
}