/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), current = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            current.next = new ListNode(0);
            current = current.next;
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum > 9 ? sum / 10 : 0;
            sum %= 10;
            current.val = sum;
        }
        return head.next;
    }
}