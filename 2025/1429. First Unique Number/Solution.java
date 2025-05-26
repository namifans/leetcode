class FirstUnique {

    Map<Integer, Integer> map = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();

    public FirstUnique(int[] nums) {
        for (int n: nums) {
            add(n);
        }
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty()) {
            if (map.get(queue.peek()) == 1) {
                return queue.peek();
            }
            queue.remove();
        }
        return -1;
    }
    
    public void add(int value) {
        if (map.containsKey(value)) {
            map.put(value, map.get(value) + 1);
        } else {
            map.put(value, 1);
            queue.add(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */