package _longest_common_prefix;

import java.util.ArrayList;

/**
 * To avoid exceed time limitation, the code became much more ugly...
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author Jinglun
 *
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lastCommonIndex = 0;
        if(strs == null || strs.length == 0){
            return "";
        }
        ArrayList<char[]> list = new ArrayList<char[]>();
        for(int i=0; i<strs.length; i++){
            list.add(strs[i].toCharArray());
        }
        int firstStringLength = strs[0].length();
        int strsLength        = strs.length;
        for(int i=0; i<firstStringLength; i++){
            char curChar = list.get(0)[i];
            //scan each String on the ith index
            for(int j=1; j<strsLength; j++){
                if(i >= list.get(j).length){
                    return strs[0].substring(0,lastCommonIndex); //a shorter String
                }
                if(list.get(j)[i] != curChar){   //find difference
                    return strs[0].substring(0,lastCommonIndex);
                }
            }
            lastCommonIndex++;
        }
        return strs[0].substring(0,lastCommonIndex);
    }
}
