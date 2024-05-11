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
    public ListNode reverseList(ListNode head) {
        ListNode rev = new ListNode();
        while (head != null) {
            ListNode tmp = rev.next;
            rev.next = head;
            ListNode next = head.next;
            head.next = tmp;
            head = next; 
        }
        return rev.next;
    }
}