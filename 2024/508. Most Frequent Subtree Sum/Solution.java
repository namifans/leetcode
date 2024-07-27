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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findSum(root, map);
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (x, y) -> (y.getValue() - x.getValue())
        ); 
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            heap.add(e);
        }
        List<Integer> list = new ArrayList<>();
        Map.Entry<Integer, Integer> last = null;
        while (!heap.isEmpty()) {
            if (list.isEmpty()) {
                last = heap.remove();
                list.add(last.getKey());
            }
            else {
                if (heap.peek().getValue() == last.getValue()) {
                    list.add(heap.remove().getKey());
                } else {
                    break;
                }
            }           
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int findSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return 0;
        int sum = root.val;
        sum += findSum(root.left, map);
        sum += findSum(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}