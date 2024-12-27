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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        index = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode build(int left, int right, int[] inorder, int[] postorder) {
        if (left > right) {
            return null;
        }
        int val = postorder[index--];
        TreeNode n = new TreeNode(val);
        n.right = build(map.get(val) + 1, right, inorder, postorder);
        n.left = build(left, map.get(val) - 1, inorder, postorder);
        return n;
    }
}