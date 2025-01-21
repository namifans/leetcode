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
        Queue<ListNode> heap = new PriorityQueue<>((x, y) -> x.val - y.val);
        ListNode head = new ListNode(), dummy = head;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                heap.add(lists[i]);
        }
        while (!heap.isEmpty()) {
            ListNode t = heap.remove();
            if (t.next != null) {
                heap.add(t.next);
            }
            head.next = t;
            head = head.next;
        }
        return dummy.next;
    }
}