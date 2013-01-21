package _zigzag_conversion;

public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuffer buffer = new StringBuffer();
        if(s == null || s.length() == 0){
            return "";
        }
        if(nRows == 1){
            return s;
        }
        int sLen = s.length();
        //first row
        for(int i=0; i<sLen; i+= (nRows-1)*2){
            buffer.append(s.substring(i, i+1));
        }
        //mid rows
        
        for(int row=1; row<nRows - 1; row++){
            int j = (nRows - row - 1)*2;
            for(int k=row; k<sLen; k+= (nRows-1)*2){
                buffer.append(s.substring(k, k+1));
                if(k+j < sLen)
                    buffer.append(s.substring(k+j, k+j+1));
            }
            j-=2;
        }
        //bottom row
        for(int i=nRows-1; i<sLen; i+=(nRows-1)*2){
            buffer.append(s.substring(i, i+1));
        }
        return buffer.toString();
    }
}