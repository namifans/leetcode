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
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> sortedMap = new TreeMap<>();
        traverse(root, 0, 0, sortedMap);
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer,List<Integer>>> entry : sortedMap.entrySet()) {
            Map<Integer, List<Integer>> colMap = entry.getValue();
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer,List<Integer>> e : colMap.entrySet()) {
                Collections.sort(e.getValue());
                list.addAll(e.getValue());
            }
            res.add(list);
        }
        return res;
    }

    private void traverse(TreeNode root, int row, int col, Map<Integer, Map<Integer, List<Integer>>> sortedMap) {
        if (root == null)
            return;
        Map<Integer, List<Integer>> rowMap = sortedMap.getOrDefault(col, new TreeMap<>());
        List<Integer> list = rowMap.getOrDefault(row, new ArrayList<>());
        list.add(root.val);
        rowMap.put(row, list);
        sortedMap.put(col, rowMap);
        traverse(root.left, row + 1, col - 1, sortedMap);
        traverse(root.right, row + 1, col + 1, sortedMap);
    }
}