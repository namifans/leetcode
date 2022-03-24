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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode getBST(int[] nums, int start, int end) {
        if (start > end) 
            return null;
        int m = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = getBST(nums, start, m - 1);
        root.right = getBST(nums, m + 1, end);
        return root;
    }
}