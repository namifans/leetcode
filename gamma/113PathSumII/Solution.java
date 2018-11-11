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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return helper(root, sum, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> helper(TreeNode root, int sum, 
        List<Integer> current, List<List<Integer>> list) {
        if (root == null)
            return list;
        if (root.val == sum && root.left == null && root.right == null) {
            current.add(root.val);
            list.add(new ArrayList(current));
            current.remove(current.size() - 1);
            return list;
        }
        current.add(root.val);
        helper(root.left, sum - root.val, current, list);
        helper(root.right, sum - root.val, current, list);
        current.remove(current.size() - 1);
        return list;
    }
}