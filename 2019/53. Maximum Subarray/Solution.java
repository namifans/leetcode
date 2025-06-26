class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur + nums[i] > nums[i]) {
                cur += nums[i];
            } else  {
                cur = nums[i];
            }
            if (cur >= max) {
                max = cur;
            }
        }
        return max;
    }
}