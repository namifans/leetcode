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
        ListNode mid = getMid(head);
        ListNode first = sortList(head);
        ListNode second = sortList(mid);
        return merge(first, second);
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        
        ListNode h = new ListNode(), dummy = h;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                h.next = h1;
                h1 = h1.next;
            } else {
                h.next = h2;
                h2 = h2.next;
            }
            h = h.next;
        }     
        h.next = h1 == null ? h2 : h1;
        return dummy.next;
    }
    
    private ListNode getMid(ListNode head) {
        ListNode prev = new ListNode(), slow = head, fast = head;
        prev.next = slow;
        while (fast != null && fast.next != null) {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
}