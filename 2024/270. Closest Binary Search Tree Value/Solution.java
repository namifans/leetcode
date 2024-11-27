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
    public int closestValue(TreeNode root, double target) {
        if (root.val > target && root.left != null) {
            int left = closestValue(root.left, target);
            if (Math.abs(left - target) <= Math.abs(root.val - target))
                return left;   
        } else if (root.val < target && root.right != null) {
            int right = closestValue(root.right, target);
            if (Math.abs(right - target) < Math.abs(root.val - target))
                return right;
        }
        return root.val;
    }
}