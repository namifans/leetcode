/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
		ListNode head = new ListNode(0);
		ListNode current = head;
		int carry = 0;
		while (L1 != null || L2 != null || carry != 0) {
			int temp = carry; 
			if (L1 != null) {
				temp += L1.val;
				L1 = L1.next;
			}
			if (L2 != null) {
				temp += L2.val;
				L2 = L2.next;
			}
			carry = temp / 10;
			ListNode node = new ListNode(temp % 10);
			current.next = node;
			current = current.next;
		} 
		return head.next;
	}
}