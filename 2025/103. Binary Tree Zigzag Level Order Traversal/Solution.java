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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzag(root, res, 0);
        return res;
    }

    private void zigzag(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null)
            return;
        if (res.size() <= depth) {
            res.add(new ArrayList<>());
        } 
        List<Integer> list = res.get(depth);
        if (depth % 2 == 0)
            list.add(root.val);
        else
            list.add(0, root.val);
        zigzag(root.left, res, depth + 1);
        zigzag(root.right, res, depth + 1);
    } 
}