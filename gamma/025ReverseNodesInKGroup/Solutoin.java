/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head, fast = dummy, tmp = dummy;
        int count;
        while (true) {
            count = k;
            while (count > 0 && fast != null) {
                fast = fast.next;
                count--;
            }
            if (fast == null)
                break;
            while (tmp.next != fast && slow.next != null) {
                tmp.next = slow.next;
                slow.next = fast.next;
                fast.next = slow;
                slow = tmp.next;
            }
            count = k;
            while (count > 0) {
                tmp = tmp.next;
                count--;
            }
            fast = tmp;
            slow = tmp.next;
        }
        return dummy.next;
    }
}