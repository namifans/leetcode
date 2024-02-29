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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        cut(root, res);
        return res;
    }
    
    public int cut(TreeNode root, List<List<Integer>> list) {
        if (root == null)
            return 0;
        int dep = Math.max(cut(root.left, list), cut(root.right, list)) + 1;
        if (list.size() < dep) {
            list.add(new ArrayList<Integer>());
        }
        List<Integer> l = list.get(dep - 1);
        l.add(root.val);
        return dep;
     }
}