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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(), fast = head.next;
        dummy.next = head;
        ListNode slow = dummy;
        while (slow.next != null && fast != null) {
            slow.next.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = slow.next.next;
            if (slow.next != null)
                fast = slow.next.next;
        }
        return dummy.next;
    }
}