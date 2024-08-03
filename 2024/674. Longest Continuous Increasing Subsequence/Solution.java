class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0, inc = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                max = Math.max(inc, max);
            } else {
                inc = 1;
            }
        }
        return Math.max(max, inc);
    }
}