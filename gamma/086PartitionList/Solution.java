/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0), right = new ListNode(0);
        ListNode lp = left, rp = right;
        while (head != null) {
            if (head.val < x) {
                lp.next = head;
                lp = lp.next;
            } else {
                rp.next = head;
                rp = rp.next;
            }
            head = head.next;
        }
        rp.next = null;
        lp.next = right.next;
        return left.next;
    }
}