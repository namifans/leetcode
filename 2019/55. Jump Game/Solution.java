class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) 
            return true;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (last == 0) {
                return false;
            } else {
                last = Math.max(last - 1, nums[i]);
            }
        }
        return true;
    }
}