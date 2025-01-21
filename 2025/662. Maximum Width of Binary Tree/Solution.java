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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        int max = 0;
        queue.offer(new Pair(0, root));
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelMin = queue.peek().getKey();
            int levelMax = levelMin;
            for (int i = 0; i < levelSize; i++) {
                Pair<Integer, TreeNode> p = queue.remove();
                int index = p.getKey();
                TreeNode n = p.getValue();
                if (n.left != null)
                    queue.offer(new Pair(index * 2 + 1, n.left));
                if (n.right != null)    
                    queue.offer(new Pair(index * 2 + 2, n.right));
                levelMax = index;
            }
            max = Math.max(max, levelMax - levelMin + 1);
        }
        return max;
    }
}