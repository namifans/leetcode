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
    public int countNodes(TreeNode root) {
        return countNodes(root, 0);
    }

    public int countNodes(TreeNode root, int d) {
        if (root == null) {
            return (int) Math.pow(2, d - 1);
        } else if (root.left == null && root.right == null) {
            return (int) Math.pow(2, d);
        } else if (root.left != null && root.right == null) {
            return (int) countNodes(root.left, d + 1) + (int) Math.pow(2, d);
        } else {
            return (int) countNodes(root.right, d + 1) + (int) Math.pow(2, d) - 1;
        }
    }
}