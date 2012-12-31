package _merge_k_sorted_lists;

import java.util.ArrayList;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
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

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode head = new ListNode(0); // will return head.next
		ListNode curNode = head; // current ListNode in result list
		int tmpMin = Integer.MAX_VALUE; // minimum value in lists
		ListNode tmpNode = new ListNode(0); // ListNode with minimum val
		boolean isFinish = false; // true if at least one node is not null
		int listNum; // the index of which node to be added to result

		if (lists == null || lists.isEmpty()) {
			return null;
		}

		while (true) {
			isFinish = true;
			listNum = 0;
			tmpMin = Integer.MAX_VALUE;

			// scan lists and find the ListNode that contains the min value
			for (int i = 0; i < lists.size(); i++) {
				ListNode node = lists.get(i);
				// skip null
				if (node == null) {
					continue;
				}
				isFinish = false;
				if (node.val < tmpMin) {
					tmpMin = node.val;
					tmpNode = node;
					listNum = i;
				}
			}
			if (isFinish) {
				break;
			}

			ListNode curMin = new ListNode(tmpNode.val);
			curNode.next = curMin;
			curNode = curMin;
			lists.set(listNum, lists.get(listNum).next);

		}
		return head.next;
	}
}