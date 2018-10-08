/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        head = tmp;
        ListNode slow = tmp.next, fast = tmp.next.next;
        while (fast != null) {
            slow.next = fast.next;
            fast.next = slow;
            tmp.next = fast;
            fast = fast.next;
            slow = tmp.next;
            if (fast.next == null)
                break;
            fast = fast.next.next;
            slow = slow.next.next;
            tmp = tmp.next.next;
        }
        return head.next;
    }
}