class MyHashSet {

    int map[];

    public MyHashSet() {
        map = new int[1000001];
        map[0] = -1;
    }
    
    public void add(int key) {
        map[key] = key;
    }
    
    public void remove(int key) {
        map[key] = 0;
    }
    
    public boolean contains(int key) {
        return map[key] == key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */