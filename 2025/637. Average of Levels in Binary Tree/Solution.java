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
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> sum = new ArrayList<>();
        getSum(root, 0, sum);
        List<Double> res = new ArrayList<>();
        for (List<Integer> l : sum) {
            long s = 0;
            for (int i : l) {
                s += i;
            }
            res.add((double)s / l.size());
        }
        return res;
    }
    
    private void getSum(TreeNode root, int d, List<List<Integer>> sum) {
        if (root == null)
            return;
        if (sum.size() <= d) {
            sum.add(new ArrayList<>());
        }
        List<Integer> current = sum.get(d);
        current.add(root.val);
        getSum(root.left, d + 1, sum);
        getSum(root.right, d + 1, sum);
    }
}