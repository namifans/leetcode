class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        }
        int[] d0 = new int[nums.length + 1];
        int[] d1 = new int[nums.length + 1]; 
        d0[0] = 0;
        d1[1] = nums[1];
        d0[1] = nums[0];
        d1[1] = 0;
        for (int i = 2; i <= nums.length; i++) {
            d0[i] = Math.max(d0[i - 1], d0[i - 2] + nums[i - 1]);
            d1[i] = Math.max(d1[i - 1], d1[i - 2] + nums[i - 1]);
        }
        return Math.max(d0[nums.length - 1], d1[nums.length]);
    }
}