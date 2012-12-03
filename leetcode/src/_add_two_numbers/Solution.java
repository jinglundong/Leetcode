package _add_two_numbers;
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
	 public class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) {
		         val = x;
		         next = null;
		     }
		 }
	 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0;
        ListNode resultHead = new ListNode((l1.val + l2.val)%10);
        carry = (l1.val + l2.val)/10;
        ListNode previous = resultHead;
        ListNode node;
        while(l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            node = new ListNode((l1.val + l2.val + carry)%10);
            carry = (l1.val + l2.val + carry)/10;
            previous.next = node;
            previous = node;
        }
        if (l1.next == null && l2.next == null){
            if (carry != 0){
                previous.next = new ListNode(1);
            }            
            return resultHead;            
        }
        if (l2.next == null){
            ListNode tmp = l2;
            l2 = l1;
            l1 = tmp;
        }
        //l1.next == null
        while( l2.next != null){
            l2 = l2.next;
            node = new ListNode((l2.val + carry)%10);
            carry = (l2.val + carry)/10;
            previous.next = node;
            previous = node;
        }
        if (carry != 0){
            previous.next = new ListNode(1);
        }
        return resultHead;
        
    }
}