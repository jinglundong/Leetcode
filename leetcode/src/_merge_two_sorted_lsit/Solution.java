package _merge_two_sorted_lsit;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	/**
	 * Merge two sorted linked lists and return it as a new list. 
	 * The new list should be made by splicing together the nodes of the first two lists.
	 * @author Jinglun
	 * AC
	 */
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
        
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head;
        if (l1.val <= l2.val){
            head = new ListNode(l1.val);
            l1 = l1.next;
        }
        else{
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode previous;
        previous = head;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                ListNode cur = new ListNode(l1.val);
                l1 = l1.next;
                previous.next = cur;
                previous = cur;
            }
            else{
                ListNode cur = new ListNode(l2.val);
                l2 = l2.next;
                previous.next = cur;
                previous = cur;
            }
        }
        if (l1 == null){
            ListNode tmp = l2;
            l2 = l1;
            l1 = tmp;
        }
        while(l1 != null){
            ListNode cur = new ListNode(l1.val);
            l1 = l1.next;
            previous.next = cur;
            previous = cur;
        }
        return head;
    }
}
