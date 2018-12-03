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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left, tmp = root.right;
        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            left.right = tmp;
            root.right = root.left;
            left.right = tmp;
            root.left = null;
        }
    }
}