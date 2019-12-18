/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null)
            return null;
        Node nh = new Node(), dummy = nh, cur = head;
        Stack<Node> s = new Stack<>();
        while (cur != null || !s.isEmpty()) {
            if (cur == null) {
                cur = s.pop();
            }
            nh.next = cur;
            if (cur == null)
                continue;
            cur.prev = nh;
            nh = nh.next;
            if (cur.child != null) {
                s.push(cur.next);
                Node t = cur.child;
                cur.child = null;
                cur = t;
            } else {
                cur = cur.next;
            }
        }
        dummy = dummy.next;
        dummy.prev = null;
        return dummy;
    }
}