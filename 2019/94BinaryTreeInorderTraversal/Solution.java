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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> s = new Stack<>();
        TreeNode c = root;
        while(c != null || !s.isEmpty()) {
            while(c != null) {
                s.push(c);
                c = c.left;
            }
            c = s.pop();
            list.add(c.val);
            c = c.right;
        }
        return list;
    }
}