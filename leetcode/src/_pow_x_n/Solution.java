package _pow_x_n;

public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        boolean negativePow = n < 0? true: false;
        n = Math.abs(n);
        String binary = Integer.toBinaryString(n);
        double result = 1;
        double product = x;
        for(int i=binary.length()-1; i>=0; i--){
            if(binary.charAt(i) == '1'){
                result *= product;
            }
            product *= product;
        }
        if(negativePow){
            result = 1/result;
        }
        return result;
    }
}
