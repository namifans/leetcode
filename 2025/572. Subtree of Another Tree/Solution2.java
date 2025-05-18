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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return serialize(root).contains(serialize(subRoot));
    }

    private String serialize(TreeNode root) {
        if (root != null) {
            return "#" + root.val + serialize(root.left) + serialize(root.right);
        } else {
            return "#nil";
        }
    }
}