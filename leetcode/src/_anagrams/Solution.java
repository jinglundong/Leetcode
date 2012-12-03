package _anagrams;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();        
        ArrayList<String> result = new ArrayList<String>();
        for (String str: strs){
            if (!map.containsKey(myHash(str))){
                map.put(myHash(str), new ArrayList<String>());
                map.get(myHash(str)).add(str);
            }
            else{                
                map.get(myHash(str)).add(str);                                    
            }
        }
        for (ArrayList<String> strList: map.values()){
            for (int i=0; i<strList.size(); i++){
                for (int j=0; j<strList.size();j++){
                    if (i==j){
                        continue;
                    }
                    if (isAnagram(strList.get(i), strList.get(j))){
                        result.add(strList.get(i));
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    public static int myHash(String str){
        if (str == null || str.isEmpty()){
            return 0;
        }
        int hash = 0;
        char[] charAry = str.toCharArray();
        for (int i =0; i< charAry.length; i++){
            hash += charAry[i]-'a';
        }
        return hash;
    }
    
    public static boolean isAnagram(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        char[] charAry1 = str1.toCharArray();
        char[] charAry2 = str2.toCharArray();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i=0; i<str1.length(); i++){
            count1[charAry1[i] - 'a']++;
            count2[charAry2[i] - 'a']++;
        }
        for (int i=0; i<26; i++){
            if (count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
}
