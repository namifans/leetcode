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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        traverse(root, 0, order);
        // Collections.reverse(order);
        return order;
    }

    private void traverse(TreeNode root, int level, List<List<Integer>> order) {
        if (root == null)
            return;
        int current = 0;
        if (order.size() <= level) {
            order.add(0, new ArrayList<>());
        } else {
            current = order.size() - level - 1;
        }
        List<Integer> list = order.get(current);
        list.add(root.val);
        traverse(root.left, level + 1, order);
        traverse(root.right, level + 1, order);
    }
}