package _roman_to_integer;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author jinglun
 * 
 */
public class Solution {
    private int cur;
    private int cumulate;
    private int result;

    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        /**
         * I = 1 V = 5 X = 10 L = 50 C = 100 D = 500 M = 1000
         * 
         **/

        this.cur = 0;
        this.cumulate = 0;
        this.result = 0;
        char[] charArray = s.toLowerCase().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
            case 'i':
                helper(1);
                break;
            case 'v':
                helper(5);
                break;
            case 'x':
                helper(10);
                break;
            case 'l':
                helper(50);
                break;
            case 'c':
                helper(100);
                break;
            case 'd':
                helper(500);
                break;
            case 'm':
                helper(1000);
                break;
            default:
                return 0;
            }
        }
        // flush the last cumulated value
        helper(0);
        return result;
    }

    private void helper(int num) {
        if (this.cur == num) {
            this.cumulate += num;
        } else {
            this.cur = num;
            if (cumulate > num) {
                result += cumulate;
            } else {
                result -= cumulate;
            }
            this.cumulate = num;
        }
    }
}