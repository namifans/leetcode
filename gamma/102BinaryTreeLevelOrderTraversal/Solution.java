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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (result.size() == level) {
            result.add(level, new ArrayList<>());
        }
        List<Integer> current = result.get(level);
        current.add(root.val);
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
    }
}