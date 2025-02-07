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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean found = false;
        while (!queue.isEmpty()) {
            TreeNode n = queue.remove();
            if (n == null) {
                found = true;
            } else {
                if (found) {
                    return false;
                }
                queue.add(n.left);
                queue.add(n.right);
            }
        }
        return true;
    }
}