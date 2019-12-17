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
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, new ArrayList<>(), result);
        return result;
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> result) {
        if (root == null)
            return;
        if (root.val == sum && (root.left == null) && (root.right == null)) {
            cur.add(root.val);
            result.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        cur.add(root.val);
        pathSum(root.left, sum - root.val, cur, result);
        pathSum(root.right, sum - root.val, cur, result);
        cur.remove(cur.size() - 1);
    }
}