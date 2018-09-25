/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) 
            return (l1 != null) ? l1 : l2;
        ListNode result = new ListNode(0), head = result;
        if (l1 == null && l2 == null)
            return result;
        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode current = new ListNode(0);
            head.next = current;
            current.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        ListNode l = (l1 != null) ? l1 : l2;
        while (l != null) {
            ListNode current = new ListNode(0);
            head.next = current;
            current.val = (l.val + carry) % 10;
            carry = (l.val + carry) / 10;
            l = l.next;
            head = head.next;
        } 
        if (carry != 0) {
            ListNode current = new ListNode(carry);
            head.next = current;
        }
        return result.next;
    }
}