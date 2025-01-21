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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int count = path(root, targetSum, 0);
        count += pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        return count;
    }

    private int path(TreeNode root, int targetSum, long sum) {
        if (root == null)
            return 0;
        int count = 0;
        if (sum + root.val == targetSum)
            count++;
        count += path(root.left, targetSum, sum + root.val);
        count += path(root.right, targetSum, sum + root.val);
        return count;
    }
}