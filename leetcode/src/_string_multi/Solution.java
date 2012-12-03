package _string_multi;

import java.util.LinkedList;
public class Solution {
    public static String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if ( num1.isEmpty() || num2.isEmpty() || num1.equals("0") || num2.equals("0")){
            return "0";
        }
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        if (num1.length() < num2.length()){ //make num2 shorter            
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        list1 = parse(num1);
        list2 = parse(num2);
        for (int i=0; i<list2.size(); i++){
            result = listAdd(result, shift(listMultiInt(list1, list2.get(i)), i));
        }
        StringBuffer buffer = new StringBuffer();
        String str = "";
        for (int i=result.size()-1; i>=0; i--){
            str = String.valueOf(result.get(i));
            if (i != result.size()-1){
                for (int j=0; j<4-str.length(); j++){
                    buffer.append("0");
                }
            }
            buffer.append(str);
        }
        return buffer.toString();
    }
    
    public static LinkedList<Integer> listAdd(
        LinkedList<Integer> list1, LinkedList<Integer> list2){
        
        LinkedList<Integer> result = new LinkedList<Integer>();
        int maxSize = Math.max(list1.size(), list2.size());
        int num1 = 0;
        int num2 = 0;
        int carry = 0;
        for (int i=0; i< maxSize; i++){
            if (i >= list1.size()){
                num1 = 0;
            }
            else{
                num1 = list1.get(i);
            }
            if (i >= list2.size()){
                num2 = 0;
            }
            else{
            	num2 = list2.get(i);
            }
            
            result.add((num1+num2+carry) % 10000);
            carry = (num1+num2+carry) / 10000;
        }
        if (carry != 0){
            result.add(carry);
        }
        return result;
    }
    
    public static LinkedList<Integer> shift(LinkedList<Integer> list, int amount){
    	LinkedList<Integer> result = new LinkedList<Integer>();
        for(int i=0; i<amount; i++){
            result.addFirst(0);
        }
        result.addAll(list);
        return result;
    }
    
    public static LinkedList<Integer> listMultiInt(LinkedList<Integer> list, Integer num){
        LinkedList<Integer> result = new LinkedList<Integer>();
        int carry = 0;
        int tmp = 0;
        for(int i=0; i< list.size(); i++){
            tmp = num * list.get(i);
            result.add((tmp + carry) % 10000);
            carry = (tmp + carry) / 10000;            
        }
        if(carry != 0){
        	result.add(carry);
        }        
        return result;
    }
    
    public static LinkedList<Integer> parse(String num){
        LinkedList<Integer> result = new LinkedList<Integer>();
        String subString = "";        
        for (int i=num.length(); i-4 >= 0; i-=4){
            subString = num.substring(i-4, i);
            result.add(Integer.parseInt(subString));
        }
        if (num.length() % 4 != 0){
            subString = num.substring(0, num.length() %4);
            result.add(Integer.parseInt(subString));
        }      
        return result;
    }
}