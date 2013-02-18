public class Solution {
    ArrayList<Integer> result;
    
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(result == null){
            result = new ArrayList<Integer>();
            result.add(0);
            result.add(1);
        }
            
        if(n < 0)
            return result;
        
        if(1<<n <= result.size()){
            return new ArrayList<Integer>(result.subList(0, 1<<n));
        }
        
        while(1<<n > result.size()){
            int bits = getBit(result.size());
            int pairIndex = result.size();
            while(pairIndex > 0){
                result.add(result.get(pairIndex-1) | (1 << bits -1));
                pairIndex--;
            }
        }
        return new ArrayList<Integer>(result);
    }
    
    private int getBit(int n){
        int result = 0;
        while(n != 0){
            result += 1;
            n = n >> 1;
        }
        return result;
    }    
}
