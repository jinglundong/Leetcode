package _add_binary;
/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

AC
 * @author Jinglun
 *
 */
public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (a == null || a.isEmpty()){
            return b;
        }
        if (b == null || b.isEmpty()){
            return a;
        }
        a = reverse(a);
        b = reverse(b);
        String[] strA = a.split("");
        String[] strB = b.split("");
        int i=1;
        boolean carry = false;
        StringBuffer sb = new StringBuffer();
        while(i < strA.length || i < strB.length){            
            carry = sub(strA, strB, sb, i, carry);        
            i++;
        }
        if (carry){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
    
    public static boolean sub(String[] strA, String[] strB, StringBuffer sb, int i, boolean carry){
        String aValue = (i<strA.length)?strA[i] : "0";
        String bValue = (i<strB.length)?strB[i] : "0";
        if (carry){
            if (aValue.equals( "0") && bValue.equals( "0")){                
                sb.append("1");
                return false;
            }
            if (aValue.equals( "1") && bValue .equals( "1")){
                sb.append("1");
                return true;
            }
            sb.append("0");
            return true;
        }
        else{       //carry == false
            if (aValue.equals("0") && bValue .equals("0")){                    
                sb.append("0");
                return false;
            }
            if (aValue.equals( "1") && bValue.equals( "1")){
                carry = true;
                sb.append("0");
                return true;
            }
            sb.append("1");
            return false;
        }        
    }
    
    public static String reverse(String str){
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }
    
}