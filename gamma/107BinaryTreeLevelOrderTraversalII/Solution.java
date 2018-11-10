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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int depth = getDepth(root);
        for (int i = 0; i < depth; i++) {
            result.add(new ArrayList());
        }
        helper(root, depth - 1, result);
        return result;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        List<Integer> current = result.get(level);
        current.add(root.val);
        helper(root.left, level - 1, result);
        helper(root.right, level - 1, result);
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}