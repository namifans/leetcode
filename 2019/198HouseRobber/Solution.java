class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        if (nums.length < 2)
            return nums[1];
        int[] d = new int[nums.length];
        d[0] = nums[0];
        d[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + nums[i]);
        }
        return d[nums.length - 1];
    }
}