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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        paths(root, list, new StringBuilder());
        return list;
    }

    private void paths(TreeNode root, List<String> list, StringBuilder s) {
        if (root == null)
            return;
        int len = s.length();
        if (!s.isEmpty())
            s.append("->");
        s.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(s.toString());
            s.setLength(len);
            return;
        }
        paths(root.left, list, s);
        paths(root.right, list, s);
        s.setLength(len);
    }
}