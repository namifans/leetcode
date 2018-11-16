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
        ListNode tmpA = headA, tmpB = headB;
        int lenA = 0, lenB = 0;
        while (tmpA != null) {
            tmpA = tmpA.next;
            lenA++;
        }
        while (tmpB != null) {
            tmpB = tmpB.next;
            lenB++;
        }
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while(diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            while(diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}