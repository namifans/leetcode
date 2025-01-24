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
        if (head == null || head.next == null)
            return head;
        ListNode half = split(head);
        ListNode left = sortList(head);
        ListNode right = sortList(half);
        return merge(left, right);
    }

    private ListNode split(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        return half;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(), tmp = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        if (left == null)
            tmp.next = right;
        else
            tmp.next = left;
        return dummy.next;
    }

}