package _string_to_integer;

public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str == null || str.length() == 0){
            return 0;
        }
        boolean sign = false;
        int i=0;
        int result = 0;
        str = str.trim();
        if(!isDigit(str.charAt(0))){
            if(str.charAt(0) == '+'){
                sign = false;
                i++;
            }
            else{
                if(str.charAt(0) == '-'){
                    sign = true;
                    i++;
                }
                else{
                    //throw new IllegalArgumentException();
                    return 0;
                }
            }
        }
        while(i < str.length() && str.charAt(i) == '0'){
            i++;
        }
        while(i < str.length()){
            if(!isDigit(str.charAt(i)))
                return sign? -1 * result: result;
            if(result > Integer.MAX_VALUE/10){
                if(sign)
                    return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            result *= 10;
            result += str.charAt(i) - '0';
            if(isOverflow(sign, result)){
                if(sign)
                    return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            i++;
        }
        return sign? -1 * result: result;
    }
    
    private boolean isDigit(char c){
        if(c>='0' && c <= '9')
            return true;
        return false;
    }
    
    private boolean isOverflow(boolean sign, int num){
        if(num < 0)
            return true;
        
        return false;
    }
}