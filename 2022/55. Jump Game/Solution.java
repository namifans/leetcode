class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int jump = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (jump == 0) {
                return false;
            }
            jump = Math.max(jump - 1, nums[i]);
        }
        return jump >= 0;
    }
}