class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < n; i++) {
            int tmp = max;
            max = Math.max(Math.max(nums[i] * min, nums[i] * max), nums[i]);
            min = Math.min(Math.min(nums[i] * min, nums[i] * tmp), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}