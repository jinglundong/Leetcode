package _reverse_node_in_k_group;

import _reverse_linkedList_II.Solution.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
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

	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null) {
			return null;
		}
		if (k <= 1) {
			return head;
		}
		ListNode cur = head;
		ListNode prev = null;
		ListNode result = reverseSub(head, k, true);
		prev = cur;
		cur = cur.next;
		while (cur != null) {
			prev.next = reverseSub(cur, k, true);
			prev = cur;
			cur = cur.next;
		}
		return result;
	}

	public ListNode reverseSub(ListNode head, int k, boolean recersive) {
		if (head == null || k <= 1) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		int count = 0;
		while (cur != null && count < k) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}
		head.next = cur;
		if (count != k && recersive) { // not a full frame. reverse again.
			return reverseSub(prev, k, false);
		}
		return prev;
	}
}