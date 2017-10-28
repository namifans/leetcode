class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0], maxCurrent = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCurrent = maxCurrent + nums[i] > nums[i] ? maxCurrent + nums[i] : nums[i];
            max = Math.max(maxCurrent, max);
        }
        return max;
    }
}