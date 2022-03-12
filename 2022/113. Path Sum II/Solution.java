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
    
    public void pathSum(TreeNode root, int targetSum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null)
            return;
        cur.add(root.val);
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(cur));
        } else {
            pathSum(root.left, targetSum, cur, res);
            pathSum(root.right, targetSum, cur, res);
        }
        cur.remove(cur.size() - 1);
    }
}