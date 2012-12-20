package _distinct_subsequences;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author Jinglun
 * 
 */
import java.util.Map;
import java.util.HashMap;

public class Solution {
    private String S;
    private String T;
    private int len_s;
    private int len_t;
    //pt_s as outer key, pt_t as inner key
    private Map<Integer, HashMap<Integer, Integer>> cache;  
    
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.S = S;
        this.T = T;
        len_s = S.length();
        len_t = T.length();
        cache = new HashMap<Integer, HashMap<Integer,Integer>>();
        return subDistinct(0, 0);
    }
    
    private int subDistinct(int pt_s, int pt_t){
        if (pt_t >= len_t){
            return 1;
        }
        if (pt_s >= len_s){ //scan to the end of S and still not found match
            return 0;
        }
        if (len_s - pt_s < len_t - pt_t){
            return 0;
        }
        if (len_s - pt_s == len_t - pt_t){
            if (S.substring(pt_s).equals(T.substring(pt_t))){
                return 1;
            }
            else{
                return 0;
            }
        }
        if (S.charAt(pt_s) == T.charAt(pt_t)){
            if (cache.containsKey(pt_s) && cache.get(pt_s).containsKey(pt_t)){      //return from cache
                return cache.get(pt_s).get(pt_t);
            }       
            //put result to cache
            int tmp = subDistinct(pt_s + 1, pt_t +1) + subDistinct(pt_s + 1, pt_t);
            if (!cache.containsKey(pt_s)){
                cache.put(pt_s, new HashMap<Integer, Integer>());
            }
            cache.get(pt_s).put(pt_t, tmp);
            return tmp;
        }
        //the current characters are not equal.
        /*
        if (cache.containsKey(pt_s) && cache.get(pt_s).containsKey(pt_t)){  //return from cache
            return cache.get(pt_s).get(pt_t);
        }
        int tmp = subDistinct(pt_s + 1, pt_t);
        if (!cache.containsKey(pt_s)){
            cache.put(pt_s, new HashMap<Integer, Integer>());
        }
        cache.get(pt_s).put(pt_t, tmp);
        */
        return  subDistinct(pt_s + 1, pt_t);
    }
}
