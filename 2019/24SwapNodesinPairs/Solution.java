/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        while (l.next != null && l.next.next != null) {
            ListNode m = l.next, r = l.next.next;
            m.next = r.next;
            r.next = l.next;
            l.next = r;
            l = l.next.next;
        }
        return dummy.next;
    }
}
