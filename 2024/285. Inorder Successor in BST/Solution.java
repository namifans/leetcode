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

    boolean found = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        TreeNode left = inorderSuccessor(root.left, p);
        if (left != null)
            return left;
        if (found == true) {
            return root;
        }
        if (root.val == p.val) {
            found = true;
        }
        return inorderSuccessor(root.right, p);
    }
}