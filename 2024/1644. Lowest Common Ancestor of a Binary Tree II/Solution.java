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

    boolean foundP = false;
    boolean foundQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode f = find(root, p, q);
        if (foundP && foundQ) {
            return f;
        } else {
            return null;
        }
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);    
        if (root == p) {
            foundP = true;
            return root;
        }
        if (root == q) {
            foundQ = true;
            return root;
        }
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

}