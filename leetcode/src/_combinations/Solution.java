package _combinations;

import java.util.ArrayList;

public class Solution {
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
        if(k <= 0){
            return prev;
        }
        for(int i=1; i<=n; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(i);
            prev.add(tmp);
        }
        for(int i=2; i<=k; i++){    //each iteration, append one more element to each list
            for(ArrayList<Integer> list: prev){ //try to append one more valid element
                for(int j=list.get(list.size()-1)+1; j <=n; j++){ //increasing order
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.addAll(list);
                    tmp.add(j);
                    cur.add(tmp);
                }
            }    
            prev = cur;
            cur = new ArrayList<ArrayList<Integer>>();
        }
        return prev;
        
    }
    
    
}
