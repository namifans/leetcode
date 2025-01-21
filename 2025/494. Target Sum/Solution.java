class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, 1, -nums[0], target) + find(nums, 1, nums[0], target) ;
    }

    private int find(int[] nums, int pos, int current, int target) {
        if (pos == nums.length && current == target) {
            return 1;
        }
        if (pos >= nums.length) {
            return 0;
        }
        int count = 0;
        count += find(nums, pos + 1, current + nums[pos], target);
        count += find(nums, pos + 1, current - nums[pos], target);
        return count;
    }
}