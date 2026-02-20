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
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        getLongest(root, null, 1);
        return max;
    }

    private void getLongest(TreeNode root, TreeNode parent, int path) {
        if (root == null) {
            return;
        }
        path = (parent != null && root.val - parent.val == 1) ? path + 1 : 1;
        max = Math.max(path, max);
        getLongest(root.left, root, path);
        getLongest(root.right, root, path);
    }
}