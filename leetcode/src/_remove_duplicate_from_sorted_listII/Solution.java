package _remove_duplicate_from_sorted_listII;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 * @author jinglun
 * 
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;
        prev.next = head;
        ListNode cur = head;
        while (cur != null) {
            boolean dup = false;
            while (cur.next != null && cur.next.val == cur.val) {
                dup = true;
                cur = cur.next;
            }
            if (dup) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return fakeHead.next;
    }
}