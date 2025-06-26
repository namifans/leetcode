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
        ListNode head = new ListNode(0), current = head;
        Queue<ListNode> heap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (ListNode n : lists) {
            if (n != null) {
                heap.add(n);
            }
        }
        while (!heap.isEmpty()) {
            ListNode tmp = heap.poll();
            current.next = tmp;
            current = current.next; 
            if (tmp.next != null) {
                heap.add(tmp.next);
            }
        }
        return head.next;
    }
} 