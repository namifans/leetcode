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

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        find(root);
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((x, y) -> (y.getValue() - x.getValue()));
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            heap.add(e);
        }
        List<Integer> list = new ArrayList<>();
        Map.Entry<Integer, Integer> first = heap.peek();
        while (!heap.isEmpty() && heap.peek().getValue() == first.getValue()) {
            Map.Entry<Integer, Integer> e = heap.remove();
            list.add(e.getKey());
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private void find(TreeNode root) {
        if (root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        find(root.left);
        find(root.right);
    }
}