package _merge_two_sorted_lists;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
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

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// will return head.next
		ListNode head = new ListNode(0);
		ListNode cur = head;

		// main loop, append the new node with small value from l1 and l2
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = new ListNode(l1.val);
				cur = cur.next;
				l1 = l1.next;
			} else {
				cur.next = new ListNode(l2.val);
				cur = cur.next;
				l2 = l2.next;
			}
		}
		if (l1 == null && l2 == null) {
			return head.next;
		}

		// make l2 the only list with remaining nodes
		if (l2 == null) {
			l2 = l1;
		}

		// l2 != null, l1 == null, just copy nodes from l2
		while (l2 != null) {
			cur.next = new ListNode(l2.val);
			cur = cur.next;
			l2 = l2.next;
		}

		return head.next;
	}
}