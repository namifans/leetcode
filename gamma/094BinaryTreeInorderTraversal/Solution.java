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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    public TreeNode inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return null;
        TreeNode left = inorderTraversal(root.left, list);
        list.add(root.val);
        TreeNode right = inorderTraversal(root.right, list);
        return root;
    }
}