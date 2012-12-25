package _permutation_sequence;

import java.util.ArrayList;

public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> strList = new ArrayList<String>();
        k--;    //start from 0
        StringBuffer buffer = new StringBuffer();
        for (int i=1; i<=n; i++){
            strList.add(String.valueOf(i));
        }
        for (int i=n-1; i >= 0; i--){
            int fact = factorial(i);
            buffer.append(strList.get(k/fact));
            strList.remove(k/fact);
            k %= fact;
        }
        return buffer.toString();
    }
    
    private int factorial(int n){
        if (n <= 1){
            return 1;
        }
        return factorial(n-1)*n;
    }
}