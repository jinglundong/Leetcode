package _integer_to_roman;
public class Solution {
    private int num;
    private StringBuffer buffer;
    
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        /**
         * I = 1 
         * V = 5 
         * X = 10 
         * L = 50 
         * C = 100 
         * D = 500 
         * M = 1000
         **/
        this.num = num;
        this.buffer = new StringBuffer();
        
        reduceMulti(1000, "M");
        reduce(900, "CM");
        reduce(500, "D" );
        reduce(400, "CD");
        reduceMulti(100 , "C");
        reduce(90,  "XC");
        reduce(50,  "L" );
        reduce(40,  "XL");
        reduceMulti(10  , "X");
        reduce(9 ,  "IX");
        reduce(5 ,  "V" );
        reduce(4 ,  "IV");
        reduceMulti(1  , "I");

        return buffer.toString();
    }
    
    private void reduce(int threshold, String str){
        if (num >= threshold){
            buffer.append(str);
            num -= threshold;
        }
    }
    
    private void reduceMulti(int threshold, String str){
        if(num >= threshold){
            for(int i=0; i<num/threshold; i++){
                buffer.append(str);
            }
            num %= threshold;
        }
    }
    
}