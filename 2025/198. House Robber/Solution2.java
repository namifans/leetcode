class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int prev = nums[0], cur =  Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = Math.max(cur, prev + nums[i]);
            prev = cur;
            cur = tmp;
        }
        return cur;
    }
}