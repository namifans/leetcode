/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0), cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = t;
        }
        return dummy.next;
    }
}