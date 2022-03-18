class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    int len;

    public MyLinkedList() {
        head = new Node(0);
        len = 0;
    }
    
    public int get(int index) {
        if (len < index)
            return -1;
        Node cur = head.next;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur == null ? -1 : cur.val;
    }
    
    public void addAtHead(int val) {
        if (head.next == null) {
            head.next = new Node(val);
        }
        else {
            Node n = new Node(val);
            n.next = head.next;
            head.next = n;
        }
        len++;
    }
    
    public void addAtTail(int val) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(val);
        len++;
    }
    
    public void addAtIndex(int index, int val) {
        if (len < index)
            return;
        Node cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        Node n = new Node(val);
        n.next = cur.next;
        cur.next = n;
        len++;
    }
    
    public void deleteAtIndex(int index) {
        if (len < index)
            return;
        Node cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
            len--;
        }
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