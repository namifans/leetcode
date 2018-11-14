/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode dummy = new ListNode(0);
        ListNode first = head, second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        second = first.next;
        first.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = dummy.next;
            dummy.next = second;
            second = tmp;
        }
        first = head;
        second = dummy.next;
        while (first != null && second != null) {
            ListNode firstNext = first.next, secondNext = second.next;
            second.next = first.next;
            first.next = second;
            first = firstNext;
            second = secondNext;
        }
    }
}