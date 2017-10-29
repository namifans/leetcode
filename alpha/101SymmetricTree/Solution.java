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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null && right != null) || (left != null && right == null))
            return false;
        boolean isMirror = (left.val == right.val) 
            && isMirror(left.right, right.left)
            && isMirror(left.left, right.right);
        return isMirror;
    }
}