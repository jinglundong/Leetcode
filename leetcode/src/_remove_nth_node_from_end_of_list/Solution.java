package _remove_nth_node_from_end_of_list;

import java.util.HashSet;

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

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author jinglun
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode resultPrev = new ListNode(0);
        resultPrev.next = head;
        int i = 1;
        while (cur != null) {
            if (i < n + 1) {
                cur = cur.next;
                i++;
            } else {
                resultPrev = resultPrev.next;
                cur = cur.next;
            }
        }
        if (resultPrev.next == head) {
            return resultPrev.next.next;
        } else {
            resultPrev.next = resultPrev.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(2));
        HashSet<String> set = new HashSet<String>();
        for (String it : set) {
            System.out.println(it);
        }
        System.out.println(Integer.parseInt("000"));
    }
}