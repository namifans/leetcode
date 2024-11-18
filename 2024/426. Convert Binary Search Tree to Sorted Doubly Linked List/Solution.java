/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        Node head = new Node(), last = head;
        List<Node> list = new ArrayList<>();
        traverse(root, list);
        for (Node n : list) {
            head.right = n;
            head = head.right;
        }
        last = head;
        Collections.reverse(list);
        for (Node n : list) {
            head.left = n;
            head = head.left;
        }
        last.right = head;
        head.left = last;
        return head;
    }

    private void traverse(Node root, List<Node> list) {
        if (root == null)
            return;
        traverse(root.left, list);
        list.add(root);
        traverse(root.right, list);
    }
}