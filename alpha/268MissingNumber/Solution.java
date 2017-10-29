class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++) {
            miss = miss ^ i ^ nums[i];
        }
        return miss;
    }
}