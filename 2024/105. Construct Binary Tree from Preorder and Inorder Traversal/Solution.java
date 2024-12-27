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

    Map<Integer, Integer> map; 
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build(0, preorder.length - 1, preorder, inorder);
        return root;
    }

    private TreeNode build(int left, int right, int[] preorder, int[] inorder) {
        if (left > right)
            return null;
        int val = preorder[index++];
        TreeNode n = new TreeNode(val);
        n.left = build(left, map.get(val) - 1, preorder, inorder);
        n.right = build(map.get(val) + 1, right, preorder, inorder);
        return n;
    }
}