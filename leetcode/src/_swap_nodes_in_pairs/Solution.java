package _swap_nodes_in_pairs;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed. Definition for singly-linked
 * list. 
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

	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null) { // zero or one elements
			return head;
		}
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head.next;
		ListNode prev = new ListNode(0);
		ListNode cur = head;
		prev.next = cur;
		ListNode next = cur.next;
		while (cur != null && cur.next != null) {
			next = cur.next;
			prev.next = next;
			cur.next = next.next;
			next.next = cur;
			prev = cur;
			cur = cur.next;
		}

		return fakeHead.next;
	}
}
