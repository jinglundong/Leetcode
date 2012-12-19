package _divide_two_integers;

public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean negative = false;   //if result is negative
        if (divisor == 0){
            throw new ArithmeticException("divide by zero");
        }
        if (dividend == 0){
            return 0;
        }
        //make dividend and divisor negative numbers
        if (dividend > 0){
            dividend = 0 - dividend;
            if (divisor < 0){
                negative = true;
            }
            else{
                divisor = 0 - divisor;
            }
        }
        else{
            if (divisor > 0){
                negative = true;
                divisor = 0 - divisor;
            }
        }
        //now both of them are negative
        //But we still need to deal with Integer.MIN_VALUE
        if (divisor == Integer.MIN_VALUE){
            if (dividend == Integer.MIN_VALUE){
                return 1;
            }
            else{
                return 0;
            }
        }
        if (dividend == Integer.MIN_VALUE){
            if (negative){
                return -1 - divide(dividend - divisor, divisor);
            }
            return 1 + divide(dividend - divisor, divisor);
        }
        //Scan from the largest n where divisor^n <= dividend
        //It's a little bit weird because the dividend and divisor are both negative 
        int result = 0;
        int base = 1;
        while(divisor<<1 >= dividend && divisor<<1 < 0){
            divisor = divisor << 1;
            base = base << 1;
        }
        while(base > 0 ){
            if (dividend <= divisor){
                dividend -= divisor;
                result -= base;
            }
            base = base >> 1;
            divisor = divisor >> 1;
        }
        return negative? result: 0 - result;
    }
}
