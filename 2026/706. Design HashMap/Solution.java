class MapNode {
    int key, val;
    MapNode next;
    public MapNode(int key, int val, MapNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

class MyHashMap {
    
    private static int SIZE = 1997;
    private static int MUL = 1031;
    MapNode[] map;

    public MyHashMap() {
        map = new MapNode[SIZE];
    }

    private int hash(int key) {
        return key * MUL % SIZE;
    }
    
    public void put(int key, int value) {
        remove(key);
        int h = hash(key);
        map[h] = new MapNode(key, value, map[h]);
    }
    
    public int get(int key) {
        int h = hash(key);
        MapNode node = map[h];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        MapNode node = map[h];
        if (node == null) {
            return;
        }
        if (node.key == key) {
            map[h] = node.next;
            return;
        }
        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                return;       
            }
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */