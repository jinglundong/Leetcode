package _partition_list_in_place;

/**
 * A in-place solution.
 * If extra space can be used, the solution will be much more simpler.
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
		}
		ListNode largerHead = new ListNode(0);
		ListNode smallerHead = new ListNode(0);
		smallerHead.next = null;
		ListNode cur = head;
		ListNode largerCur = null;
		ListNode lastSmall = null;
		while (cur != null) {
			if (cur.val < x) { // smaller part
				if (smallerHead.next == null) { // save the head of smaller part
					smallerHead.next = cur;
				}
				if (lastSmall != null) { // append the smaller number of the
											// list
					lastSmall.next = cur;
				}
				lastSmall = cur;
			} else { // larger part
				if (largerHead.next == null) { // save the head of larger part
					largerHead.next = cur;
					largerCur = cur;
				} else { // append to the larger list
					largerCur.next = cur;
					largerCur = cur;
				}
			}
			cur = cur.next;
		}
		if (largerCur != null) {
			largerCur.next = null;
		}
		if (lastSmall == null) { // every number is >= than the given one
			return largerHead.next;
		} else {
			lastSmall.next = largerHead.next;
		}
		return smallerHead.next;

	}
}