package _plus_one;

/**
 * Given a number represented as an array of digits, plus one to the number.
 * @author Jinglun
 *
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0;
        digits[digits.length -1]++;
        if (digits[digits.length -1] == 10){
            carry = 1;
            digits[digits.length -1] = 0;
        }
        for (int i = digits.length-2; i >= 0; i--){
            if (digits[i] + carry >9){
                digits[i] = 0;
                carry = 1;
            }
            else{
                digits[i] += carry;
                carry = 0;
            }
        }    
        if (carry == 1){    //return a new int[] with one more digit
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int i=0; i<digits.length; i++){
                result[i+1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}