class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int prevMax = 0, currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = currentMax;
            currentMax = Math.max(prevMax + nums[i], currentMax);
            prevMax = temp;
        }
        return currentMax;
    }
}