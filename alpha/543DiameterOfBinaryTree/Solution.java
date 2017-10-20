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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int maxRoot = maxDepth(root.left) + maxDepth(root.right);
        int maxRight = diameterOfBinaryTree(root.right);
        int maxLeft = diameterOfBinaryTree(root.left);
        return Math.max(maxLeft, Math.max(maxRight, maxRoot));
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}