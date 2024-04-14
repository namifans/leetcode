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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode l1 = head, l2 = head;
        while (l1 != null && l2 != null) {
            while (l2!= null && l1.val == l2.val) {
                l2 = l2.next;
            }
            l1.next = l2;
            l1 = l1.next;
        }
        return dummy.next;
    }
}