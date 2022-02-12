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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode knode = dummy, slow = head, fast = head;
        int n = k;
        while (knode != null && n > 0) {
            knode = knode.next;
            n--;
        }
        n = k;
        while (fast != null && n > 0)  {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        int tmp = knode.val;
        knode.val = slow.val;
        slow.val = tmp;
        return dummy.next;
    }
}