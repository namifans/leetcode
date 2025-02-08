/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        return connect(root, null);
    }

    private Node connect(Node root, Node right) {
        if (root == null)
            return root;
        if (root.left != null) {
            root.left.next = root.right;
            connect(root.left, root.right);
        }
        if (root.right != null) {
            if (right != null) {
                root.right.next = right.left;
                connect(root.right, right.left);
            } else {
                root.right.next = null;
                connect(root.right, null);
            }
        }
        return root;
    }
}