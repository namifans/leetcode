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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(), cur = head, prev = dummy;
        dummy.next = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        cur = head;
        while (cur != null) {
            if (count < k)
                break;
            prev = reverse(cur, prev, k);
            cur = prev.next;
            count -= k;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode prev, int k) {
        ListNode dummy = new ListNode(), cur = head;
        dummy.next = head;
        while (cur != null && cur.next != null && k > 1) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
            k--;
        }
        return cur;
    }
}