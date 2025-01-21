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

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return traverse(node, map);
    }

    private Node traverse(Node node, Map<Integer, Node> map) {
        if (node == null)
            return node;
        if (map.containsKey(node.val)) 
            return map.get(node.val);
        Node newnode = new Node(node.val);
        map.put(node.val, newnode);
        newnode.neighbors = new ArrayList<>();
        for (Node n : node.neighbors) {
            Node tmp = traverse(n, map);
            newnode.neighbors.add(tmp);
        }
        return newnode;
    }
}