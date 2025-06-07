class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> monoDecreasingQueue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!monoDecreasingQueue.isEmpty() && monoDecreasingQueue.peekLast() < nums[i]) {
                    monoDecreasingQueue.pollLast();
            }
            monoDecreasingQueue.offerLast(nums[i]);
            if (i >= k - 1) {
                res[j++] = monoDecreasingQueue.peekFirst();
                if (!monoDecreasingQueue.isEmpty() && monoDecreasingQueue.peekFirst() == nums[i - k + 1]) {
                    monoDecreasingQueue.pollFirst();
                }
            }
        }
        return res;
    }
}