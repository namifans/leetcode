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
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root.left, root, k) || findTarget(root, root.right, k)  ;
    }
    
    public boolean findTarget(TreeNode left, TreeNode right, int k) {
        if (left == null || right == null)
            return false;
        if (left.val + right.val == k && left != right) {
            return true;
        } else if (left.val + right.val < k) {
            return findTarget(left.right, right, k) || findTarget(left, right.right, k);
        } else {
            return findTarget(left, right.left, k) || findTarget(left.left, right, k);
        }
    }
}