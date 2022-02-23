class Solution {
    
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }
    
    private int rob(int[] nums, int start, int end) {
        int[] rob = new int[end - start + 1];
        rob[start] = nums[start];
        rob[(start + 1) % end] = Math.max(nums[start], nums[(start + 1) % end]);
        for (int i = start + 2; i < end; i++) {
            rob[i] = Math.max(rob[i - 2] + nums[i], rob[i - 1]);
        }
        return rob[end - 1];
    }
}