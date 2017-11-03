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
        ListNode tempA = headA, tempB = headB;
        int countA = 0, countB = 0;
        while (tempA != null) {
            countA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            countB++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB = headB;
        if (countA > countB) {
            int count = countA - countB;
            while(tempA != null && count > 0) {
                tempA = tempA.next;
                count--;
            }
        } else {
            int count = countB - countA;
            while(tempB != null && count > 0) {
                tempB = tempB.next;
                count--;
            }
        }
        while (tempA != null && tempB != null) {
            if (tempA == tempB)
                return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}