package _letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    ArrayList<StringBuffer> buffers;
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        buffers = new ArrayList<StringBuffer>();
        Map<Integer, ArrayList<String>> map = 
            new HashMap<Integer, ArrayList<String>>();
        init(map);
        
        for(int i=0; i<digits.length(); i++){
            ArrayList<String> tmpList = map.get(Integer.parseInt(digits.substring(i,i+1)));
            ArrayList<StringBuffer> tmpBuffers = new ArrayList<StringBuffer>();
            //first digit
            if (buffers.isEmpty()){
                for(String str: tmpList){
                    StringBuffer tmpBuffer = new StringBuffer(str);
                    buffers.add(tmpBuffer);
                }
                continue;
            }
            //the rest digits
            for(StringBuffer buffer: buffers){
                for(String str: tmpList){
                    StringBuffer tmpBuffer = new StringBuffer(buffer);
                    tmpBuffer.append(str);
                    tmpBuffers.add(tmpBuffer);
                }
            }
            buffers = tmpBuffers;
        }
        ArrayList<String> result = new ArrayList<String>();
        
        //toString
        for(StringBuffer buffer: buffers){
            result.add(buffer.toString());
        }
        
        //deal with empty input
        if (result.isEmpty()){
            result.add("");
        }
        return result;
    }
    
    //init number string map
    private void init(Map<Integer, ArrayList<String>> map){
        
        Character tmpChar = 'a';
        //button 1
        tmpChar = charToString(map, tmpChar, 3, 2);
        tmpChar = charToString(map, tmpChar, 3, 3);
        tmpChar = charToString(map, tmpChar, 3, 4);
        tmpChar = charToString(map, tmpChar, 3, 5);
        tmpChar = charToString(map, tmpChar, 3, 6);
        tmpChar = charToString(map, tmpChar, 4, 7);
        tmpChar = charToString(map, tmpChar, 3, 8);
        tmpChar = charToString(map, tmpChar, 4, 9);
        
    }
    
    //register each entry of map
    private Character charToString(Map<Integer, ArrayList<String>> map, 
        Character tmpChar, int amount, int num){
        
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i=0; i<amount; i++){
            list.add(tmpChar.toString());
            tmpChar++;
        }
        
        map.put(num, list);
        return tmpChar;
    }
}