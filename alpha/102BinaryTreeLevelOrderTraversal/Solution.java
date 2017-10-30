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
        List<List<Integer>> result = new ArrayList();
        if (root == null)
            return result;
        traverse(root, 0, result);
        return result;
    }

    public void traverse(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (result.size() <= depth) {
            result.add(depth, new LinkedList<Integer>());
        }
        List<Integer> current = result.get(depth);
        current.add(root.val);
        traverse(root.left, depth + 1, result);
        traverse(root.right, depth + 1, result);
    }
}