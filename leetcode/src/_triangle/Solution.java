package _triangle;

import java.util.ArrayList;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (triangle == null){
            return 0;
        }
        ArrayList<Integer> tmp = new ArrayList<Integer>(triangle.get(triangle.size()-1));
        for (int i=triangle.size()-2; i>=0; i--){
            for (int j=0; j<i+1; j++){
                tmp.set(j, triangle.get(i).get(j) + Math.min(tmp.get(j), tmp.get(j+1)));
            }
        }
        return tmp.get(0);
    }
}
