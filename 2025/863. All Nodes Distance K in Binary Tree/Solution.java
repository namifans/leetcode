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

    Map<TreeNode, TreeNode> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        addParent(null, root);
        findNode(target, k, res);
        return res;
    }

    private void addParent(TreeNode prev, TreeNode cur) {
        if (cur != null) {
            map.put(cur, prev);
            addParent(cur, cur.left);
            addParent(cur, cur.right);
        }
    }

    private void findNode(TreeNode cur, int k, List<Integer> res) {
        if (cur == null || !map.containsKey(cur)) {
            return;
        }
        if (k == 0) {
            res.add(cur.val);
            return;
        }
        TreeNode parent = map.get(cur);
        map.remove(cur);
        findNode(parent, k - 1, res);
        findNode(cur.left, k - 1, res);
        findNode(cur.right, k - 1, res);
    }
}