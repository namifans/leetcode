/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(), slow = dummy;
        dummy.next = head;
        while (slow != null) {
            if (slow.next != null && slow.next.val == 0) {
                slow.next = slow.next.next;
                slow = slow.next;
            } else {
                ListNode fast = slow.next;
                while (fast != null && fast.val != 0) {
                    slow.val += fast.val;
                    slow.next = fast.next;
                    fast = fast.next;
                }
                if (fast != null && fast.val == 0) {
                    slow.next = fast.next; 
                    slow = slow.next;
                } else
                    slow = fast;
            }
        }
        return dummy.next;
    }
}