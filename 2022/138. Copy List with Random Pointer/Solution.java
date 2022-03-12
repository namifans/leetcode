/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node nh = new Node(0), cur = head, dummy = nh;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node n = map.get(cur);
            n.next = map.get(cur.next);
            n.random = map.get(cur.random);
            cur = cur.next;
            nh.next = n;
            nh = nh.next;
        }
        return dummy.next;
    }
}