package _count_and_say;

public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String str = "1";
        for (int i =1; i<n; i++){
            str = read(str);
        }
        return str;
    }
    
    public static String read(String in){
        int count = 0;
        String word = "";
        String result = "";
        String[] ary = in.split("");
        for (int i=0; i<ary.length; i++){
            if (ary[i] == null || ary[i].isEmpty()){
                continue;
            }
            if (word.isEmpty()){
                count = 1;
                word = ary[i];
            }
            else{
                if (word.equals(ary[i])){
                    count++;
                }
                else{ //word != in.get(i)
                    result += count + "" + word;
                    word = ary[i];
                    count = 1;
                }
            }
        }
        result += count + "" + word;
        return result;
    }
}
