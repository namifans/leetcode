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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0, 0);
    }

    public int helper(TreeNode root, int current, int sum) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            sum += current * 10 + root.val;
            return sum;
        }
        int leftSum = 0, rightSum = 0;
        leftSum += helper(root.left, current * 10 + root.val, sum);
        rightSum += helper(root.right, current * 10 + root.val, sum);
        return leftSum + rightSum;
    }
}