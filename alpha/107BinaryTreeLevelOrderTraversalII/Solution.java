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
        if (root == null)
            return result;
        helper(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    private void helper(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null)
            return;
        if (result.size() < depth + 1) {
            result.add(new ArrayList<Integer>());
        }
        List<Integer> current = result.get(depth);
        current.add(root.val);
        helper(root.left, depth + 1, result);
        helper(root.right, depth + 1, result);
    }
}