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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null)
            return list;
        traverse(root, list, "");
        return list;
    }

    public void traverse(TreeNode root, List<String> list, String s) {
        
        if (root.left == null && root.right == null)
            list.add(s + root.val);
        if (root.left != null)
            traverse(root.left, list, s + root.val + "->");
        if (root.right != null)
            traverse(root.right, list, s + root.val +"->");
    }
}