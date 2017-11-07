class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int max = 1, current = 1;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 1) {
                current++;
                max = Math.max(current, max);
            } else if (diff == 0) {
                continue;
            } else {
                current = 1;
            }
        }
        return max;
    }
}