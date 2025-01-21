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
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0), slow = head, fast = head;
        dummy.next = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        ListNode cur = dummy.next;
        while (!stack.isEmpty() && cur != null) {
            ListNode n = stack.pop(), tmp = cur.next;
            n.next = cur.next;
            cur.next = n;
            cur = cur.next.next;
        }
        cur.next = null;
    }
}