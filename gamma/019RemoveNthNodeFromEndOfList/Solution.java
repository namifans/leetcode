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
        int len = 0;
        ListNode slow = head, fast = head;
        int k = n;
        while (fast != null) {
            if (n < 0) {
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        if (n >= 0) {
            head = head.next;
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }
}