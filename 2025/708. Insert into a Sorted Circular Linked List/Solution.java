/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        if (head == null) {
            head = n;
            n.next = head;
        } 
        Node prev = head, nxt = head.next;
        while (nxt != head) {
            if ((prev.val < n.val && n.val <= nxt.val) || 
                (prev.val > nxt.val && n.val <= nxt.val) ||
                (prev.val > nxt.val && n.val > prev.val))
                break;
            prev = prev.next;
            nxt = nxt.next;            
        }
        n.next = nxt;
        prev.next = n;
        return head;
    }
}