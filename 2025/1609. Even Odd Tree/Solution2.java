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
    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>(); 
        traverse(root, 0, map);
        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            List<Integer> list = e.getValue();
            if (e.getKey() % 2 == 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        if (list.get(i) % 2 == 0) {
                            return false;
                        }
                        break;
                    }
                    if (list.get(i) >= list.get(i + 1) || list.get(i) % 2 == 0) 
                        return false;
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        if (list.get(i) % 2 != 0) {
                            return false;
                        }
                        break;
                    }
                    if (list.get(i) <= list.get(i + 1) || list.get(i) % 2 != 0) 
                        return false;
                }
            }
        }
        return true;
    }

    public void traverse(TreeNode root, int lvl, Map<Integer, ArrayList<Integer>> map) {
        if (map.get(lvl) == null) {
            map.put(lvl, new ArrayList<>());
        }
        if (root != null) {
            ArrayList<Integer> list = map.get(lvl);
            list.add(root.val);
            map.put(lvl, list);
            traverse(root.left, lvl + 1, map);
            traverse(root.right, lvl + 1, map);
        } else 
            return;
    }
}