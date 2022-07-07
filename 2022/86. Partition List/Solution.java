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
    public ListNode partition(ListNode head, int x) {
        Queue<ListNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        while (head != null) {
            ListNode cur = head;
            if (cur.val < x) {
                q1.add(cur);
            } else {
                q2.add(cur);
            }
            head = head.next;
            cur.next = null;
        }
        ListNode res = new ListNode(), dummy = new ListNode();
        dummy = res;
        while (!q1.isEmpty() || !q2.isEmpty()) {
            res.next = q1.isEmpty() ? q2.poll() : q1.poll();
            res = res.next;
        }
        return dummy.next;
    }
}