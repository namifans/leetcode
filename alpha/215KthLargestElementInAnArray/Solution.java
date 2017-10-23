class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int i : nums) {
            queue.offer(i);
        }
        while (k-- > 1) {
            queue.poll();
        }
        return queue.peek();
    }
}