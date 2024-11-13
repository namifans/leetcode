class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    Node head, tail;
    int len, capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(-1, -1, null, null);
        this.tail = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            Node n = map.get(key);
            moveNode(n);
            return n.value;
        }
        return res;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            moveNode(n);
        } else {
            Node n = new Node(key, value, tail, null);
            tail.next = n;
            tail = tail.next;
            tail.next = null;
            map.put(key, n);
            evictNode();
        }
    }

    private void moveNode(Node n) {
        if (tail != n) {
            n.next.prev = n.prev; 
            n.prev.next = n.next; 
            tail.next = n;
            n.prev = tail;
            tail = tail.next;
            tail.next = null;   
        }
    }

    private void evictNode() {
        if (map.size() > capacity) {
            map.remove(head.next.key);
            head.next.next.prev = head;
            head.next = head.next.next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */