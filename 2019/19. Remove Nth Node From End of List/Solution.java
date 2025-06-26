/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0), prev = dummy, cur = head;
        dummy.next = head;
        while (n > 0) {
            cur = cur.next;
            n--;
        }
        while (cur != null) {
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}