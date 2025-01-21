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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode l0 = dummy, l1 = head, l2 = head.next;
        while (l2 != null) {
            if (l1.val == l2.val) {
                while (l2 != null && l1.val == l2.val) {
                    l1 = l1.next;
                    l2 = l2.next;
                }   
                l0.next = l1.next;
            } else {
                l0 = l0.next;
            }
            l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;
    }
}