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
    public ListNode sortList(ListNode head) {
        Queue<ListNode> heap = new PriorityQueue<>((x, y) -> (
            x.val - y.val
        ));
        ListNode dummy = new ListNode(0), tmp = head;
        while (tmp != null) {
            heap.add(tmp);
            tmp = tmp.next;
        }
        tmp = dummy;
        while (!heap.isEmpty()) {
            ListNode n = heap.poll();
            tmp.next = n;
            tmp = tmp.next;
        }
        if (tmp != null)
            tmp.next = null;
        return dummy.next;
    }
}