package _rotate_list;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author Jinglun
 * 
 */
public class Solution {
	private int listLen;
	private ListNode tail;

	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0 || head == null) {
			return head;
		}
		setListLenAndTail(head);
		n = n % listLen;
		tail.next = head;
		for (int i = 0; i < listLen - n - 1; i++) {
			head = head.next;
		}
		ListNode newHead = head.next;
		head.next = null;
		return newHead;
	}

	private void setListLenAndTail(ListNode head) {
		if (head == null) {
			listLen = 0;
			tail = null;
			return;
		}
		listLen = 1;
		while (head.next != null) {
			head = head.next;
			listLen++;
		}
		tail = head;
	}
}