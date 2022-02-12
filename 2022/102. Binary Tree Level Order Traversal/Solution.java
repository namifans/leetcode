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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelTraverse(root, 0, result);
        return result;
    }
    
    private void levelTraverse(TreeNode root, int depth, List<List<Integer>> result) {
        if (root != null) {
            List<Integer> list;
            if (result.size() <= depth) {
                list = new ArrayList<Integer>();
                result.add(list);
            } else {
                list = result.get(depth);
            }
            list.add(root.val);
            levelTraverse(root.left, depth + 1, result);
            levelTraverse(root.right, depth + 1, result);
        }
        
    }
}