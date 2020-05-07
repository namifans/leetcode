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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        int n = 0;
        while (fast != null) {
            n++;
            fast = fast.next;
        }
        fast = head;
        k %= n;
        while (fast.next != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}

// 1 2 3 4 5
// 1 2 3 4 5 
//     s p f
// f.next = dummy.next;
// slow.next = null;

