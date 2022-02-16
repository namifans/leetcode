class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] jump = new int[nums.length];
        jump[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (jump[i - 1] == 0)
                return false;
            jump[i] = Math.max(jump[i - 1] - 1, nums[i]);
        }
        return true;
    }
}