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
    
    TreeNode nr = new TreeNode(0);
    
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return root;
        TreeNode dummy = nr;
        increasing(root);
        return dummy.right;
    }
    
    public void increasing(TreeNode root) {
        if (root == null)
            return;
        increasing(root.left);
        TreeNode n = new TreeNode(root.val);
        nr.right = n;
        nr = nr.right;
        increasing(root.right);
    }
}