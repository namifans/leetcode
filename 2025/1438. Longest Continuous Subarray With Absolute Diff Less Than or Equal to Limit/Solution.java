class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> increaseQueue = new ArrayDeque<>(), decreaseQueue = new ArrayDeque<>();
        int res = 0, l = 0;
        for (int r = 0; r < nums.length; r++) {
            int val = nums[r];
            while (!increaseQueue.isEmpty() && increaseQueue.peekLast() > val) {
                increaseQueue.pollLast();
            }
            while (!decreaseQueue.isEmpty() && decreaseQueue.peekLast() < val) {
                decreaseQueue.pollLast();
            }
            increaseQueue.offerLast(val);
            decreaseQueue.offerLast(val);
            if (Math.abs(increaseQueue.peekFirst() - decreaseQueue.peekFirst()) <= limit) {
                res = Math.max(res, r - l + 1);
            } else {
                if (increaseQueue.peekFirst() == nums[l]) {
                    increaseQueue.pollFirst();
                }
                if (decreaseQueue.peekFirst() == nums[l]) {
                    decreaseQueue.pollFirst();
                }
                l++;
            }
        }
        return res;
    }
}