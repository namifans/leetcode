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


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), prev = dummy, slow = head, fast = head.next;
        while (fast != null) {
            ListNode tmp = fast.next;
            fast.next = slow;
            slow.next = tmp;
            prev.next = fast;
            if (tmp == null) {
                break;
            }
            prev = slow;
            slow = tmp;
            fast = slow.next;
        }
        return dummy.next;
    }
}

// 1->2->3->4
// s  f  t
// ->1->2->1 t->3
// 2->1->3
// 
