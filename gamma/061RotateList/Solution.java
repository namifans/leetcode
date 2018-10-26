/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null|| k == 0)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        int len = 1;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }
        if (k % len == 0)
            return head;
        k = len - (k % len);
        while (k > 0) {
            slow = slow.next;
            k--;
        }
        dummy.next = slow.next;
        fast.next = head;
        slow.next = null;
        return dummy.next;
    }
}