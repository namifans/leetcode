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
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode dummy = new TreeNode();
        TreeNode cur = dummy;
        traversal(root, list);
        for (TreeNode n : list) {
            cur.right = n;
            n.left = null;
            cur = cur.right;
        }
        root = dummy.right;
    }

    private void traversal(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        list.add(root);
        traversal(root.left, list);
        traversal(root.right, list);
    }
}