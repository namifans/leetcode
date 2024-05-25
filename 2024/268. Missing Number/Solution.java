class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, exp = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            exp += i;
        }
        return exp - sum;
    }
}