package _reverse_integer;

public class Solution1 {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean sign = false;
        if(x < 0){
            sign = true;
            x *= -1;
        }
        double reversed = 0;
        while(x > 0){
            reversed *= 10;
            reversed += x%10;
            x /= 10;
        }
        if(sign){
            if(reversed >= (double)Integer.MIN_VALUE * -1)
                return Integer.MIN_VALUE;
        }
        else{
            if(reversed >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        return sign? -1 * (int)reversed: (int) reversed;
    }
}