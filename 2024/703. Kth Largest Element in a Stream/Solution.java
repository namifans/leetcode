class KthLargest {

    Queue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>(k);
        this.k = k;
        for (int i : nums) {
            addHeap(i);
        }
    }
    
    public int add(int val) {
        addHeap(val);
        return heap.peek();
    }

    private void addHeap(int val) {
        heap.add(val);
        if (heap.size() > k)
            heap.remove();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */