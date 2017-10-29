/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head, prev = dummy;
        while (current != null) {
            if (current.val == val) {
                current = current.next;
                prev.next = current;
            } else {
                current = current.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}