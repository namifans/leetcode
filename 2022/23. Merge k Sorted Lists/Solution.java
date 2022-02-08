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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0), dummy = head;
        Queue<ListNode> heap = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode n : lists) {
            if (n != null) {
                heap.offer(n);
            }
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.remove();
            head.next = cur;
            head = head.next;
            if (cur.next != null) {
                heap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}