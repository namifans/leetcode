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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode dummy = new ListNode(), slow = dummy, fast = head;
        dummy.next = head;
        int len = 1;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }
        k %= len;
        if (k == 0)
            return head;
        while (slow != null && len - k > 0)  {
            slow = slow.next;
            k++;
        }
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dummy.next;
    }
}