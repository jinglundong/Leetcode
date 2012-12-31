package _merge_sorted_array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space to hold additional elements from
 * B. The number of elements initialized in A and B are m and n respectively.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int cur = m + n - 1;

		while (cur >= 0) {
			// check if B is empty now
			if (n < 1) {
				return;
			}

			// check if A is empty now
			if (m < 1) {
				for (int i = 0; i < n; i++) {
					A[i] = B[i];
				}
				return;
			}

			// A and B both have at least one element, put the larger one to the
			// end of A
			if (A[m - 1] > B[n - 1]) {
				A[cur] = A[m - 1];
				m--;
			} else {
				A[cur] = B[n - 1];
				n--;
			}
			cur--;
		}
	}
}