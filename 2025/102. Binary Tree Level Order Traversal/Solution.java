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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, 0, res);
        return res;
    }

    private void traverse(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null)
            return;
        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }
        List<Integer> l = list.get(level++);
        l.add(root.val);
        traverse(root.left, level, list);
        traverse(root.right, level, list);
    }
}