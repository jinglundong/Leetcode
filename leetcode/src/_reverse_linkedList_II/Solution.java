package _reverse_linkedList_II;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
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
	 
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
		}
		if (n == m) {
			return head;
		}
		if (m == 1) {
			return reverseFromFirst(head, n);
		}
		ListNode cur = head;
		ListNode prev = head;
		for (int i = 1; i < m; i++) {
			prev = cur;
			cur = cur.next;
		}
		prev.next = reverseFromFirst(cur, n - m + 1);
		return head;
	}

	public ListNode reverseFromFirst(ListNode head, int length) {
		if (head == null) {
			return head;
		}
		if (length <= 1) {
			return head;
		}
		ListNode originHead = head;
		ListNode cur = head;
		ListNode prev = null;
		ListNode next = null;
		int count = 0;
		while (cur != null && count < length) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}
		originHead.next = next;
		return prev;
	}
}