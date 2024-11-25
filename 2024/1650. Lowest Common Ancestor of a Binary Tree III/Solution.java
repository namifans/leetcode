/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Map<Integer, Node> map = new HashMap<>();
        while (p.parent != null) {
            map.put(p.val, p);
            p = p.parent;
        }
        while (q.parent != null) {
            if (map.containsKey(q.val))
                return map.get(q.val);
            q = q.parent;
        }
        return p;
    }
}