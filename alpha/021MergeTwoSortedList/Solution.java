/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode L1, ListNode L2) {
		ListNode head = new ListNode(0);
		ListNode current = head;
		while (L1 != null && L2 != null) {
			if (L1.val < L2.val) {
				current.next = L1;
				L1 = L1.next;
			} else {
				current.next= L2;
				L2 = L2.next;
			}
			current = current.next;
		}
		current.next = (L1 != null) ? L1 : L2;
		return head.next;
	}
}