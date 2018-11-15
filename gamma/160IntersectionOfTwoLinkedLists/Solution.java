/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA), lenB = getLength(headB);
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) 
            moveForward(headA, diff);
        else 
            moveForward(headB, diff);
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private void moveForward(ListNode head, int diff) {
        while(diff > 0) {
            head = head.next;
            diff--;
        }
    }

    private int getLength(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        return len;
    }
}