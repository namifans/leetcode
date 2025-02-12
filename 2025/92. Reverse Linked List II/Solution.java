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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(), cur = head, prev = dummy;
        dummy.next = head;
        int nodes = right - left + 1;
        while (cur != null && left > 1) {
            cur = cur.next;
            prev = prev.next;
            left--;
        }
        ListNode start = prev;
        while (cur != null && cur.next != null && nodes > 1) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
            nodes--;
        }
        return dummy.next;
    }
}