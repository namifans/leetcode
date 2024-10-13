/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int sum = 0;

    public int findTilt(TreeNode root) {
        find(root);
        return sum;
    }

    private int find(TreeNode root) {
        if (root == null)
            return 0;
        int left = find(root.left);
        int right = find(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }
}
