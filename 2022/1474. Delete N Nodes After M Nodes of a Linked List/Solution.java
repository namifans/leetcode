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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(), cur = new ListNode();
        dummy.next = head;
        cur.next = head;
        while (cur != null) {
            int m1 = m, n1 = n;
            while (m1 > 0 && cur != null) {
                cur = cur.next;
                m1--;
            }
            while (n1 > 0 && cur != null && cur.next != null) {
                cur.next = cur.next.next;
                n1--;
            }
            if (n1 > 0) {
                cur = null;
            }        
        }
        return dummy.next;
    }
}