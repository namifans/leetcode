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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    public void pathSum(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> res) {
        if (root == null)
            return;
        list.add(root.val);
        if (targetSum == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        pathSum(root.left, targetSum - root.val, list, res);
        pathSum(root.right, targetSum - root.val, list, res);
        list.remove(list.size() - 1);
    }
}