package _search_in_rotated_sorted_array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public int search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0) {
			return -1;
		}
		if (A.length == 1) {
			if (A[0] == target) {
				return 0;
			}
			return -1;
		}
		// at least two elements
		return rotatedBinarySearch(A, target, 0, A.length - 1);

	}

	private int binarySearch(int[] A, int target, int low, int high) {
		if (low <= high) {
			if (A[low] == target) {
				return low;
			}
			if (A[high] == target) {
				return high;
			}
			int mid = low + (high - low) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[mid] < target) {
				return binarySearch(A, target, mid + 1, high);
			} else {
				return binarySearch(A, target, low, mid - 1);
			}
		}
		return -1;
	}

	private int rotatedBinarySearch(int[] A, int target, int low, int high) {
		if (low > high) {
			return -1;
		}
		if (target == A[low]) {
			return low;
		}
		if (target == A[high]) {
			return high;
		}
		int mid = low + (high - low) / 2;
		if (target == A[mid]) {
			return mid;
		}
		if (A[low] < A[high]) { // in-order
			return binarySearch(A, target, low, high);
		} else { // rotated
			if (A[mid] > A[low]) { // A[mid] is also greater than A[high]
				if (target > A[low] && target < A[mid]) {
					return binarySearch(A, target, low, mid - 1);
				} else {
					return rotatedBinarySearch(A, target, mid + 1, high);
				}
			} else { // A[mid] < A[low], A[mid] < A[high]
				if (target > A[mid] && target < A[high]) {
					return binarySearch(A, target, mid + 1, high);
				} else {
					return rotatedBinarySearch(A, target, low, mid - 1);
				}
			}
		}
	}
}
