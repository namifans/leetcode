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
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getSum(root, 0, list);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public void getSum(TreeNode root, int sum, List<Integer> list) {
        if (root == null)
            return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            list.add(sum);
            return;
        }
        getSum(root.left, sum, list);
        getSum(root.right, sum, list);
    }
}