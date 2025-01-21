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
class Node {
    int col;
    TreeNode root;
    public Node(int col, TreeNode root) {
        this.col = col;
        this.root = root;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, root));
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            if (n.root == null)
                continue;
            List<Integer> list = map.getOrDefault(n.col, new ArrayList<>());
            list.add(n.root.val);
            map.put(n.col, list);
            queue.add(new Node(n.col - 1, n.root.left));
            queue.add(new Node(n.col + 1, n.root.right));
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }
}