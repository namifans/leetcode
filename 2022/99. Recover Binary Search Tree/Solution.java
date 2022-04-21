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
    public void recoverTree(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        traverse(root, list);
        Collections.sort(list);
        reassign(root, list);
    }
    
    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
    
    public void reassign(TreeNode root, LinkedList<Integer> list) {
        if (root == null)
            return;
        reassign(root.left, list);
        root.val = list.pollFirst();
        reassign(root.right, list);
    }
}