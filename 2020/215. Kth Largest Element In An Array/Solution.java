class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> (i1 - i2));
        for (int i : nums) {
            if (heap.size() < k) {
                heap.add(i);
            } else {
                if (i > heap.peek()) {
                    heap.add(i);
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}