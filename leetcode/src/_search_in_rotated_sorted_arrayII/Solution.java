package _search_in_rotated_sorted_arrayII;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public boolean search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null || A.length == 0) {
			return false;
		}
		if (A.length == 1) {
			if (A[0] == target) {
				return true;
			}
			return false;
		}
		// at least two elements
		return rotatedBinarySearch(A, target, 0, A.length - 1);
	}

	private boolean binarySearch(int[] A, int target, int low, int high) {
		if (low <= high) {
			if (A[low] == target) {
				return true;
			}
			if (A[high] == target) {
				return true;
			}
			int mid = low + (high - low) / 2;
			if (A[mid] == target) {
				return true;
			}
			if (A[mid] < target) {
				return binarySearch(A, target, mid + 1, high);
			} else {
				return binarySearch(A, target, low, mid - 1);
			}
		}
		return false;
	}

	private boolean rotatedBinarySearch(int[] A, int target, int low, int high) {
		if (low > high) {
			return false;
		}
		if (target == A[low]) {
			return true;
		}
		if (target == A[high]) {
			return true;
		}
		int mid = low + (high - low) / 2;
		if (target == A[mid]) {
			return true;
		}
		if (A[low] < A[high]) { // in-order
			return binarySearch(A, target, low, high);
		} else { // rotated
			// cases that A[mid] equals head or tail
			if (A[mid] == A[low]) {
				return rotatedBinarySearch(A, target, mid + 1, high)
						|| rotatedBinarySearch(A, target, low, mid - 1);
			}
			if (A[mid] == A[high]) {
				return rotatedBinarySearch(A, target, low, mid - 1)
						|| rotatedBinarySearch(A, target, mid + 1, high);
			}
			// Just like the original question
			if (A[mid] > A[low]) { // A[mid] is also greater than A[high]
				if (target > A[low] && target < A[mid]) {
					return binarySearch(A, target, low, mid - 1);
				} else {
					return rotatedBinarySearch(A, target, mid + 1, high);
				}
			} else { // A[mid] <= A[low], A[mid] <= A[high]
				if (target > A[mid] && target < A[high]) {
					return binarySearch(A, target, mid + 1, high);
				} else {
					return rotatedBinarySearch(A, target, low, mid - 1);
				}
			}
		}
	}
}
