package _first_missing_positive;

public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //keep swapping elements that try to maintain an array such that A[i] = i+1 
        if (A == null || A.length == 0){
            return 1;
        }
        for(int i=0; i<A.length; i++){
            while(A[i] != i+1 && A[i] > 0){
                //swap A[i] with the element located on A[A[i]-1]
                if (A[i]-1 < 0 || A[i]-1 >= A.length || A[A[i]-1] == A[i]){
                    break;
                }
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];   
                A[i] = tmp;                
            }
        }
        for (int i=0; i<A.length; i++){
            if (A[i] != i+1){
                return i+1;
            }
        }
        return A.length+1;
    }
}
