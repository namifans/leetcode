/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode head = new ListNode(0), dummy = head;
        Queue<ListNode> heap = new PriorityQueue<>((x, y) -> (x.val - y.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            if (cur.next != null) {
                heap.add(cur.next);
            }
            head.next = cur;
            head = head.next;
            cur.next = null;
        }
        return dummy.next;
    }
}