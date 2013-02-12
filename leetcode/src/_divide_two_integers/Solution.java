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
        //Scan from the largest n where divisor^n <= dividend
        //It's a little bit weird because the dividend and divisor are both negative 
        int result = 0;
        int base = 1;
        while(dividend <= divisor<<1 && divisor<<1 < 0){
            divisor = divisor << 1;
            base = base << 1;
        }
        while(base != 0){
            if (dividend <= divisor){
                dividend -= divisor;
                result += base;
            }
            base = base >>> 1;      //padding 0 to the left most bit
            divisor = divisor >> 1;
        }
        return negative? 0- result: result;
    }
}
