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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> treeList = new ArrayList<>();
        traverse(root, 0, treeList);
        List<Integer> res = new ArrayList<>();
        for (List<Integer> l : treeList) {
            res.add(l.get(l.size() - 1));
        }
        return res;
    }

    private void traverse(TreeNode root, int h, List<List<Integer>> treeList) {
        if (root == null)
            return;
        if (h >= treeList.size()) {
            treeList.add(new ArrayList<>());
        }
        List<Integer> list = treeList.get(h);
        list.add(root.val);
        traverse(root.left, h + 1, treeList);
        traverse(root.right, h + 1, treeList);
    }
}