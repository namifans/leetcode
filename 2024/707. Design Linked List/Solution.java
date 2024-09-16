class Node {
    public int val;
    public Node next;
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {

    private Node head;
    private Node cur;
    private int i;

    public MyLinkedList() {
        head = new Node(0, null);
        cur = null;
    }
    
    public int get(int index) {
        if (index >= i)
            return -1;
        int t = index;
        Node c = head.next;
        while (t > 0) {
            c = c.next;
            t--;
        }
        return c.val;
    }
    
    public void addAtHead(int val) {
        Node n = new Node(val, head.next);
        head.next = n;
        if (cur == null)
            cur = n;
        i++;
    }
    
    public void addAtTail(int val) {
        Node n = new Node(val, null);
        if (cur == null)
            cur = head;
        cur.next = n;
        cur = cur.next;
        i++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > i)
            return;
        int t = index;
        Node c = head;
        while (t > 0) {
            t--;
            c = c.next;
        }
        Node tmp = c.next;
        c.next = new Node(val, tmp);
        if (index == i) {
            cur = c.next; 
        }
        i++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= i || i == 0)
            return;
        Node c = head;
        int t = index;
        while (t > 0) {
            t--;
            c = c.next;
        }
        if (c.next == null)
            return;
        c.next = c.next.next;
        if (index == i - 1)
            cur = c;
        i--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */