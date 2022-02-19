class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
        while (j < nums.length) {
            if (nums[j] >= sum && sum < 0) {
                i = j;
                sum = nums[j++];
            } else {
                sum += nums[j++];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}