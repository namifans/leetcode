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
        ListNode dummy = new ListNode(), prev = dummy, cur = head;
        dummy.next = head;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}