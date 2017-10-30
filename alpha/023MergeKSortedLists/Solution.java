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
        Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode> () {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                queue.offer(head);
            }
        }
        ListNode newHead = new ListNode(-1);
        ListNode current = newHead;
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
            if (current.next != null) {
                queue.offer(current.next);
            }
        }
        return newHead.next;
    }
}