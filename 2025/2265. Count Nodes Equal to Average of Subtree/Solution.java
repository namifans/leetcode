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

    int res;
    
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] {0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int count = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + root.val;
        if (sum / count == root.val)
            res++;
        return new int[] {count, sum};
    }
}