/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        if (length == 0)
            return null;
        return helper(head, 0, length);
    }

    private TreeNode helper(ListNode head, int start, int end) {
        if (head == null || start >= end)
            return null;
        ListNode cur = head;
        int mid = start + (end - start) / 2, tmp = mid;
        while (tmp > 0 && cur != null) {
            cur = cur.next;
            tmp--;
        }
        TreeNode node = new TreeNode(cur.val);
        node.left = helper(head, start, mid);
        node.right = helper(head, mid + 1, end);
        return node;
    }
}