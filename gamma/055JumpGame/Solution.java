class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (end - 1 <= 0 && nums[i] == 0)
                return false;
            end = Math.max(end - 1, nums[i]);
        }
        return true;
    }
}