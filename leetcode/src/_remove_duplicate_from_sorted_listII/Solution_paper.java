package _remove_duplicate_from_sorted_listII;

public class Solution_paper {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null)
			return head;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode cur = head;
		ListNode pre = fakeHead;
		boolean dup = false;

		while (cur.next != null) {
			if (cur.next.val != cur.val) {
				if (dup) {
					dup = false;
					pre.next = cur.next;
				} else
					pre = cur;
				cur = cur.next;
			} else {
				cur = cur.next;
				dup = true;
			}
		}

		if (dup)
			pre.next = null;
		return fakeHead.next;
	}
}
