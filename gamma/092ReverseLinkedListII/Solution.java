/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        int count = n - m, i = 1;
        while (i < m && cur.next != null) {
            cur = cur.next;
            prev = prev.next;
            i++;
        }
        ListNode next = cur.next;
        while (count > 0 && next != null) {
            ListNode temp = next.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cur.next;
            count--;
        }
        return dummy.next;
    }
}