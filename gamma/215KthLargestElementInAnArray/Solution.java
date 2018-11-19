class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Queue<Integer> heap = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            heap.add(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}