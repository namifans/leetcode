/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode head = node, prev = new ListNode();
        prev.next = head;
        while (head != null && head.next != null) {
            head.val = head.next.val;
            head = head.next;
            prev = prev.next;
        }
        prev.next = null;
    }
}