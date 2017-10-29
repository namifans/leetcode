class Node {
    int key, val;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    Node head, tail;
    int size = 0, cap = 0;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        cap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev; 
            moveToTail(node);
            return node.val;
        } else {
            return -1;
        }       
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev; 
            moveToTail(node);
        } else {
            if (size >= cap) {
                Node node = head.next;
                map.remove(node.key);
                head.next.next.prev = head;
                head.next = head.next.next;
                size--;
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToTail(node);
            size++;
        }
    }

    private void moveToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */