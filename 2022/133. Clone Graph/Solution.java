/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return clone(node);
    }
    
    private Node clone(Node node) {
        
        if (node == null)
            return null;
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node nh = new Node(node.val);
        visited.put(nh.val, nh);
        for (Node n : node.neighbors) {
            Node c = clone(n);
            if (c != null) {
                 nh.neighbors.add(c);
            }
        }
        return nh;
    }
}