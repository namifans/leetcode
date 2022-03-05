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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) 
            return new TreeNode(val);
        if (root.left == null && root.val > val)
            root.left = new TreeNode(val);
        else if (root.right == null && root.val < val)
            root.right = new TreeNode(val);
        else {
            if (root.val < val)
                insertIntoBST(root.right, val);
            else
                insertIntoBST(root.left, val);
        }
        return root;
    }
}