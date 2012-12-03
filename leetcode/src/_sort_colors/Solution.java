package _sort_colors;
/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 * @author Jinglun
 *
 */
public class Solution {
	/**
	 * AC
	 * @param A
	 */
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] bucket = new int[3];
        for (int i=0; i<A.length; i++){
            switch (A[i]){
                case 0:
                    bucket[0]++;
                    break;
                case 1:
                    bucket[1]++;
                    break;
                case 2:
                    bucket[2]++;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int index = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<bucket[i]; j++){
                A[index] = i;
                index++;
            }
        }     
    }
}