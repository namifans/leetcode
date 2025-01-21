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
        Node dummy = head;
        while (head != null) {
            Node n = new Node(head.val);
            map.put(head, n);
            head = head.next;
        }
        head = dummy;
        while (head != null) {
            Node n = map.get(head);
            if (head.random != null)
               n.random = map.get(head.random);
            if (head.next != null)
                n.next = map.get(head.next);
            head = head.next;
        }
        return map.get(dummy);
    }
}