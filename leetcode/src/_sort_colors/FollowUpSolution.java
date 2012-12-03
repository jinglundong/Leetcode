package _sort_colors;

public class FollowUpSolution {
	/**
	 * AC
	 * @param A
	 */
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        int oneHead = 0;        
        int twoHead = 0;        
        for (int i=0; i<A.length; i++){
            switch (A[i]){
                case 0:
                    if (oneCount == 0 && twoCount == 0){
                        zeroCount++;
                        break;
                    }
                    if (oneCount == 0 ){
                        swap(A, i, twoHead);
                        twoHead++;
                        zeroCount++;
                        break;
                    }
                    if (twoCount == 0){
                        swap(A, i, oneHead);
                        oneHead++;
                        zeroCount++;
                        break;
                    }
                    swap(A, i, oneHead);
                    swap(A, i, twoHead);
                    oneHead++;
                    twoHead++;
                    zeroCount++;
                    break;
                case 1:
                    if (twoCount == 0){
                        if (oneCount == 0){
                            oneHead = i;
                            oneCount++;
                        }
                        break;
                    }
                    if (oneCount == 0){
                        swap(A, i, twoHead);
                        oneHead = twoHead;
                        twoHead++;
                        oneCount++;
                        break;
                    }
                    swap(A, i, twoHead);
                    twoHead++;
                    oneCount++;
                    break;
                case 2:
                    if (twoCount == 0){
                        twoHead = i;
                        twoCount++;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
    
    public static void swap(int[] A, int first, int second){
        int tmp = A[first];
        A[first] = A[second];
        A[second] = tmp;
    }
}
