class Solution {
    public int findKthLargest(int[] nums, int k) {
        // max -> all, pop to k
        // min -> keep size to k
        Queue<Integer> queue = new PriorityQueue<>(k, (x, y) -> (x - y));
        for (int n : nums) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        return queue.peek();
    }
}